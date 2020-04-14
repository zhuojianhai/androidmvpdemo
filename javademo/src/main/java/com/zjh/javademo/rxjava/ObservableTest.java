package com.zjh.javademo.rxjava;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class ObservableTest {
    private static  String TAG = "ObservableTest";
    public static void main(String[] args) {
        showObservabelInfo();
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

        observable =  observable.subscribeOn(Schedulers.newThread());
        observable = observable.observeOn(Schedulers.newThread());

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
}
