package com.zjh.appui.rxjava;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.SingleTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.observable.ObservableCreate;
import io.reactivex.internal.operators.single.SingleJust;
import io.reactivex.internal.operators.single.SingleMap;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.ReplaySubject;

public class RxjavaClient {
    public static void main(String[] args) {

//        showRxjava();
//        testPublish();
//        testReplaySubject();

        showSingle();
    }

    private static  void testPublish(){
        PublishSubject<Integer> subject = PublishSubject.create();
        subject.subscribe(i -> System.out.print("(1: " + i + ") "));

        Executor executor = Executors.newFixedThreadPool(5);
        Disposable disposable = Observable.range(1, 5).subscribe(i -> executor.execute(() -> {
            try {
                Thread.sleep(i * 200);
                subject.onNext(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        subject.subscribe(i -> System.out.print("(2: " + i + ") "));

        Observable.timer(2, TimeUnit.SECONDS).subscribe(i -> ((ExecutorService) executor).shutdown());
    }

    private static void testReplaySubject(){
        ReplaySubject<Integer> subject = ReplaySubject.create();
        subject.subscribe(i -> System.out.print("(1: " + i + ") "));

        Executor executor = Executors.newFixedThreadPool(5);
        Disposable disposable = Observable.range(1, 5).subscribe(i -> executor.execute(() -> {
            try {
                Thread.sleep(i * 200);
                subject.onNext(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        subject.subscribe(i -> System.out.println("(2: " + i + ") "));

        Observable.timer(2, TimeUnit.SECONDS).subscribe(i -> ((ExecutorService) executor).shutdown());
    }

    private static void showRxjava(){

        ObservableCreate<String> observable =(ObservableCreate) Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                for (int i=0;i<10;i++) {
                    emitter.onNext("100" +i);
                }

                emitter.onComplete();
            }
        });

        Observer observer = new Observer<String>() {
             Disposable disposable;
            @Override
            public void onSubscribe(Disposable d) {
                disposable = d;
            }

            @Override
            public void onNext(String o) {
                System.out.println("receiver value is "+o);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                disposable.dispose();

            }
        };

        observable
                .subscribeOn(Schedulers.io())
                .subscribeOn(Schedulers.computation())
                .map(new Function<String, String>() {
                    @Override
                    public String apply(String s) throws Exception {

                        return s+" map-function";
                    }
                })
                .observeOn(Schedulers.trampoline())
                .subscribe(observer);
    }

    private  static void showSingle(){
        //hook
        RxJavaPlugins.setOnSingleAssembly(new Function<Single, Single>() {
            @Override
            public Single apply(Single single) throws Exception {

                return single;
            }
        });
        SingleJust<Integer> singleJust = (SingleJust<Integer>) Single.just(1);

        SingleMap<Integer,String> singleMap = (SingleMap<Integer,String>) singleJust.map(new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) throws Exception {
                return integer.toString();
            }
        });
        SingleMap<String,String>  singleMap2 = ( SingleMap<String,String>)singleMap.map(new Function<String, String>() {
            @Override
            public String apply(String s) throws Exception {
                return s+"  new string";
            }
        });

        SingleObserver<String> singleObserver = new SingleObserver<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(String s) {
                System.out.println(s);

            }

            @Override
            public void onError(Throwable e) {

            }
        };
        singleMap2
                .compose(new SingleTransformer<String, String>() {
            @Override
            public SingleSource<String> apply(Single<String> upstream) {
                return upstream;
            }
        })
                .observeOn(Schedulers.io()).subscribe(singleObserver);
    }

    private void showInterval(){
        Observable.interval(1000,1000,TimeUnit.MICROSECONDS)
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Long aLong) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
