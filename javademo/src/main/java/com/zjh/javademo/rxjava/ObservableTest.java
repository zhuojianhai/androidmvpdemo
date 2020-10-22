package com.zjh.javademo.rxjava;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;

public class ObservableTest {
    private static  String TAG = "ObservableTest";
    public static void main(String[] args) {
//        showObservabelInfo();
//
//        ObservableTest bt = new ObservableTest();
//        bt.ss();

        takeUntils();
    }


    private void ss(){
        ExecutorService executor = Executors.newScheduledThreadPool(2);
        Future<String> future = executor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                String result = "conscience";
                return "success";
            }
        });

        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static void showObservabelInfo(){
        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                System.out.println(TAG+" ObservableOnSubscribe  subscribe");
                for (int i=0;i<10;i++){
                    emitter.onNext("value is "+i);
                }

                emitter.onComplete();
            }
        });

        observable = observable.map(new Function<String, String>() {
            @Override
            public String apply(String s) throws Exception {
                return s.toUpperCase();
            }
        });

        observable =  observable.subscribeOn(Schedulers.trampoline());
        observable = observable.observeOn(Schedulers.trampoline());

        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

                System.out.println(TAG+" onSubscribe ");
            }

            @Override
            public void onNext(String s) {
                System.out.println(TAG+" onNext "+s);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                System.out.println(TAG+" onComplete ");
            }
        };

        observable.subscribe(observer);
    }

    private static void takeUntils(){
        Observable.interval(1, TimeUnit.SECONDS).
                subscribeOn(Schedulers.io())
                .takeUntil(Observable.timer(5, TimeUnit.SECONDS)).
                subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long num) throws Exception {
                        System.out.println("running num : " + num.toString());
                    }
                });
    }
    private void showSubject(){
//        BehaviorSubject<>
    }
}
