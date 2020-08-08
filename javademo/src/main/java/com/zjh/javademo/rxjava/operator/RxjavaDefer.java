package com.zjh.javademo.rxjava.operator;


import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

public class RxjavaDefer {
    Integer value = 100;
    public static void main(String[] args) {

        RxjavaDefer rxjavaDefer = new RxjavaDefer();
        rxjavaDefer.showDefer();
        rxjavaDefer.showTime();
    }

    /**
     * 这个方法的作用就是直到被观察者被订阅后才会创建被观察者
     */
    private void showDefer(){

        Integer finalValue = value;
        Observable<Integer>  observable = Observable.defer(new Callable<ObservableSource<? extends Integer>>() {
            @Override
            public ObservableSource<? extends Integer> call() throws Exception {
                return Observable.just(value);
            }
        });

        value = 200;

        Observer observer = new Observer<Integer>(){
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer integer) {

                System.out.println("show defer accept value " +integer);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

        observable.subscribe(observer);
        value =300;
        observable.subscribe(observer);

    }


    private void showTime(){
        Observable.timer(2, TimeUnit.SECONDS)
//                .map(new Function<Long, String>() {
//                    @Override
//                    public String apply(Long aLong) throws Exception {
//                        return aLong.toString();
//                    }
//                })
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Long s) {
                        System.out.println(s);

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
