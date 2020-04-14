package com.zjh.javademo.rxjava;






import org.reactivestreams.Subscription;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

public class SingleTest {
    private static final String TAG = "SingleTest";
    public static void main(String[] args) {
       // showSingle();
//        showObservableInfo();
        //showIn();

        showFlowable();
    }


    private static void showSingle(){

        //创建一个新的上游 Single 对象
        Single<Integer> single = Single.just(1);
        /**
         * SingleMap 是对Single的包装，当sigle调用 map方法，就会返回sigle的包装类SingleMap
         * ，这个类也是Single类的子类
         */
        Single<String> mapStr = single.map(new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) throws Exception {
                return "Interger to String value is "+String.valueOf(integer);
            }
        });
        Single<String> doOnSubscribe =  mapStr.doOnSubscribe(new Consumer<Disposable>() {
            @Override
            public void accept(Disposable disposable) throws Exception {
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            }
        });
        doOnSubscribe.flatMap(new Function<String, SingleSource<?>>() {
            @Override
            public SingleSource<?> apply(String s) throws Exception {
                return null;
            }
        });
        SingleObserver<String> observer = new SingleObserver<String>() {

            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("on subscribe");

            }

            @Override
            public void onSuccess(String s) {
                System.out.println("onsuccess "+s);

            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError "+e.getMessage());
            }
        };

        //执行的是SingleMap的subscribe方法
      //  mapStr.subscribe(observer);
        doOnSubscribe.subscribe(observer);


            /**
             * 简单的把int事件-->string 事件
             */
            Single.just(100).map(new Function<Integer, String>() {
                @Override
                public String apply(Integer integer) throws Exception {
                    return String.valueOf(integer);
                }
            }).subscribe(new SingleObserver<String>() {
                @Override
                public void onSubscribe(Disposable d) {
                    System.out.println("on subscribe");
                }

                @Override
                public void onSuccess(String s) {
                    System.out.println("onsuccess "+s);
                }

                @Override
                public void onError(Throwable e) {
                    System.out.println("onError "+e.getMessage());
                }
            });


    }

    private static void showObservableInfo(){

        Observable<String> p = Observable.create(new ObservableOnSubscribe() {
            @Override
            public void subscribe(ObservableEmitter emitter) throws Exception {
                emitter.onNext("hello world");
                emitter.onComplete();
            }
        });

        p = p.concatWith(new MaybeSource<String>() {
            @Override
            public void subscribe(MaybeObserver<? super String> observer) {
                observer.onSuccess("sssssssssssssss");
            }
        });
       p.subscribe(new Observer<String>() {
           @Override
           public void onSubscribe(Disposable d) {
               System.out.println("onSubscribe:");
           }

           @Override
           public void onNext(String s) {
               System.out.println("onNext:"+s);

           }

           @Override
           public void onError(Throwable e) {
               System.out.println("onError:"+e.getMessage());
           }

           @Override
           public void onComplete() {
               System.out.println("onComplete:");
           }
       });
    }


    /**
     * 1、当observable 订阅了observer的时候，首先会执行实现了Observer接口匿名内部类的onSubscribe方法
     * 2、然后执行 实现了ObservableOnSubscribe<T>接口匿名内部类的 subscribe方法
     * 3、通过ObservableEmitter对象向下游发送数据
     * 4、Observer回收到发送数据，并回调Observer的onNext方法，得到数据
     */
    private static void showIn(){

        //得到的是ObservableCreate 类的对象
        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                for (int i=0;i<10;i++){
                    emitter.onNext(i);
                }

            }
        });
        //得到的是包装了ObservableCreate对象的ObservableMap类对象
        observable = observable.map(new Function<Integer, Integer>() {

            @Override
            public Integer apply(Integer integer) throws Exception {
                return integer+integer;
            }
        });
        //ObservableFilter
        observable = observable.filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) throws Exception {
                return integer>5;
            }
        });

//        observable =   observable.subscribeOn(Schedulers.io());
//        observable = observable.subscribeOn(Schedulers.newThread());
//        observable = observable.observeOn(Schedulers.io());

        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

                System.out.println("observable onsubscribe ");
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println(integer.toString());

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

        observable.subscribe(observer);



    }


    private static void showFlowable(){
        Flowable<String> flowable = Flowable.create(new FlowableOnSubscribe<String>() {
            @Override
            public void subscribe(FlowableEmitter<String> emitter) throws Exception {
                for (int i=0;i<10000;i++){
                    emitter.onNext(i+" ");
                }

            }
        }, BackpressureStrategy.BUFFER);

//        flowable = flowable.subscribeOn(Schedulers.newThread());
//        flowable = flowable.observeOn(Schedulers.newThread());



        FlowableSubscriber<String> flowableSubscriber = new FlowableSubscriber<String>() {
            @Override
            public void onSubscribe(Subscription s) {
                s.request(Integer.MAX_VALUE);

            }

            @Override
            public void onNext(String s) {

                System.out.println("received value is "+s);
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

            }
        };

        flowable.subscribe(flowableSubscriber);



    }


}
