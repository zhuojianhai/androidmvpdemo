package com.zjh.appui.rxjava;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.ReplaySubject;

public class RxjavaClient {
    public static void main(String[] args) {

        showRxjava();
//        testPublish();
//        testReplaySubject();

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

        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
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
                .subscribeOn(Schedulers.trampoline())
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
}
