package com.zjh.appui.rxjava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.xml.transform.Source;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;

public class Test {
    public static void main(String[] args) {
        showAsynchronized();
        showInfo();
        showObservableCase();
    }

    private static void showAsynchronized(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                showInfo();
            }
        }).start();

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                //在新的綫程中执行
              showInfo();
            }
        });
        executorService.shutdown();
    }
    private static void showInfo(){
        System.out.println(Thread.currentThread().getName());
    }

    private static void showObservableCase(){
        //全局hook observable
        RxJavaPlugins.setOnObservableAssembly(new Function<Observable, Observable>() {
                                                  @Override
                                                  public Observable apply(Observable observable) throws Exception {
                                                      System.out.println(observable.getClass().toString());
                                                      return observable;
                                                  }
                                              }
        );
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                for (int i=0;i<10;i++){
                    emitter.onNext(i+"");
                }
                emitter.onComplete();
            }
        }).doOnNext(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println("doOnNext  "+s);

            }
        }).flatMap(new Function<String, ObservableSource<Integer>>() {
            @Override
            public ObservableSource<Integer> apply(String s) throws Exception {
                ObservableSource<Integer> source = Observable.just(Integer.parseInt(s));
                System.out.println("flatMap >>>");
                return source;
            }
        }).subscribeOn(Schedulers.trampoline())

        .map(new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) throws Exception {
                System.out.println("map >>>");
                return integer+"";
            }
        }).observeOn(Schedulers.trampoline())
        .subscribe(new Observer<String>() {
            Disposable disposable;
            @Override
            public void onSubscribe(Disposable d) {
                disposable = d;

            }

            @Override
            public void onNext(String s) {

                System.out.println("observer value is "+ s);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                if (disposable!=null){
                    if (!disposable.isDisposed()){
                        disposable.dispose();
                        System.out.println("dispose is executed");
                    }
                }

            }
        });
    }
}
