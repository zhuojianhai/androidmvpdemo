package com.zjh.javademo.rxjava.operator;


import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;

public class Rxjavademo1 {
    public static void main(String[] args) {
        Rxjavademo1 rxjavademo1 = new Rxjavademo1();
//        rxjavademo1.showFrom();
//        rxjavademo1.showFromCallable();
//        rxjavademo1.showFromFuture();
//        rxjavademo1.showFromIterable();
//        rxjavademo1.showFlowable();
//        rxjavademo1.showCumtomOperator();
        rxjavademo1.showThreadChange();
    }

    private void showFrom(){
        Integer array [] = {1,2,3,5};
        Observable.fromArray(array).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {

                System.out.println(integer);
            }
        });
        System.out.println("---------------------------");
    }

    /**
     * 这里的 Callable 是 java.util.concurrent 中的 Callable，
     * Callable 和 Runnable 的用法基本一致，只是它会返回一个结果值，这个结果值就是发给观察者的。
     */
    private void showFromCallable(){
        Observable.fromCallable(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Random random = new Random(100);
                return random.nextInt()*1000+"  value";
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println(s);
            }
        });

        System.out.println("---------------------------");
    }

    /**
     *
     */
    private void showFromFuture(){
        FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "返回结果";
            }
        });

        Observable
                .fromFuture(futureTask)
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        futureTask.run();
                    }
                })
                .subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {

                System.out.println(s);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
        System.out.println("---------------------------");
    }

    /**
     * 直接发送一个 List 集合数据给观察者
     */
    private void showFromIterable(){
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);

        Observable.fromIterable(list)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {

                        System.out.println("accept value "+integer);
                    }
                });
    }


    private void showFlowable(){
        Flowable.create(new FlowableOnSubscribe<Integer>() {
            @Override
            public void subscribe(FlowableEmitter<Integer> emitter) throws Exception {

                for (int i=0;i<1000000;i++){
                    emitter.onNext(i);
                }
            }
        }, BackpressureStrategy.DROP)
        .subscribe(new FlowableSubscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription s) {
                s.request(Long.MAX_VALUE);

            }

            @Override
            public void onNext(Integer integer) {
                System.out.println(integer);

            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();

            }

            @Override
            public void onComplete() {

            }
        })
        ;
    }


    private void showCumtomOperator(){
        Observable.create(new ObservableOnSubscribe<List<String>>() {
            @Override
            public void subscribe(ObservableEmitter<List<String>> emitter) throws Exception {
                List<String> list = new ArrayList<>();
                list.add("one");
                list.add("one");
                list.add("one");
                list.add("one");
                list.add("one");
                emitter.onNext(list);
            }
        }).lift(new CustomOperator())
        .subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println("自定义操作符号，得到的结果为"+s);
            }
        })
        ;
    }


    private void showThreadChange(){
        //Observable全局hook
//        RxJavaPlugins.setOnObservableAssembly(new Function<Observable, Observable>() {
//            @Override
//            public Observable apply(Observable observable) throws Exception {
//                System.out.println(observable);
//                return observable;
//            }
//        });
//
//        RxJavaPlugins.setOnObservableSubscribe(new BiFunction<Observable, Observer, Observer>() {
//            @Override
//            public Observer apply(Observable observable, Observer observer) throws Exception {
//                System.out.println("observer hook "+observer);
//                return observer;
//            }
//        });
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("1");
                System.out.println("thread name "+Thread.currentThread().getName());

            }
        }).map(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) throws Exception {
                return Integer.valueOf(s);
            }
        })
                .subscribeOn(Schedulers.single())
        .map(new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) throws Exception {
                return integer+"";
            }
        })
                .observeOn(Schedulers.io())
                .subscribeOn(Schedulers.computation())
        .subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println("thread name " +Thread.currentThread().getName());
                System.out.println("result "+s);
            }
        });



        Observable.create(new ObservableOnSubscribe<Map<String,String>>() {
            @Override
            public void subscribe(ObservableEmitter<Map<String, String>> emitter) throws Exception {
                Map<String,String> map = new HashMap<>();
                map.put("name","zhuojianhai");
                map.put("address","imagic address");
                emitter.onNext(map);
            }
        });
    }
}
