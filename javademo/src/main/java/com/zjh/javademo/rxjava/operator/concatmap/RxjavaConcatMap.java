package com.zjh.javademo.rxjava.operator.concatmap;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class RxjavaConcatMap {
    public static void main(String[] args) {
        RxjavaConcatMap rxjavaConcatMap = new RxjavaConcatMap();

        rxjavaConcatMap.showConcatMap();
    }

    private void showConcatMap(){
        Observable.create(new ObservableOnSubscribe<List<String>>() {

            @Override
            public void subscribe(ObservableEmitter<List<String>> emitter) throws Exception {
                List<String> list = new ArrayList();
                list.add("hello 1");
                list.add("hello 2");
                list.add("hello 3");
                list.add("hello 4");
                list.add("hello 5");
                list.add("hello 6");
                list.add("hello 7");
                list.add("hello 8");
                list.add("hello 9");
                list.add("hello 10");
                list.add("hello 11");
                list.add("hello 12");
                list.add("hello 13");
                emitter.onNext(list);
            }
        }).flatMap(new Function<List<String>, ObservableSource<List<String>>>() {
            @Override
            public ObservableSource<List<String>> apply(List<String> strings) throws Exception {
                return Observable.fromArray(strings);
            }
        })
                .concatMap(new Function<List<String>, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(List<String> strings) throws Exception {
                return Observable.fromIterable(strings);
            }
        })
                .subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println("result value is "+s);
            }
        });
    }

    private void showMaps(){
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("100");
            }
        }).map(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) throws Exception {
                return Integer.valueOf(s);
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer integer) {

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
