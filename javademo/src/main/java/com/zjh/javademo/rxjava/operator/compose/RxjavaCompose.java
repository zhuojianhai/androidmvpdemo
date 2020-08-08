package com.zjh.javademo.rxjava.operator.compose;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

public class RxjavaCompose {

    private static final String TAG = "RxjavaCompose";

    public static void main(String[] args) {
        RxjavaCompose r = new RxjavaCompose();
        r.concatShow();

        System.out.println("============================");
        r.showConcatArray();
        System.out.println("============================");
        r.showMerge();
    }

    /**
     * 可以将多个观察者组合在一起，然后按照之前发送顺序发送事件。需要注意的是，concat() 最多只可以发送4个事件。
     */
    private void concatShow() {
        Observable.concat(Observable.just(1, 2), Observable.just(3, 4), Observable.just(5, 6), Observable.just(7, 8))
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Integer integer) {

                        System.out.println(TAG + integer);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    /**
     * 与 concat() 作用一样，不过 concatArray() 可以发送多于 4 个被观察者。
     */
    private void showConcatArray() {
        Observable.concatArray(Observable.just(1, 2),
                Observable.just(3, 4),
                Observable.just(5, 6),
                Observable.just(7, 8),
                Observable.just(9, 10))
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        System.out.println("concatArray " + integer);
                    }
                });
    }


    /**
     * 这个方法月 concat() 作用基本一样，知识 concat() 是串行发送事件，而 merge() 并行发送事件
     */
    private void showMerge() {
//        Observable.merge(Observable.interval(1, TimeUnit.SECONDS).map(new Function<Long, String>() {
//                    @Override
//                    public String apply(Long aLong) throws Exception {
//                        return "A" + aLong;
//                    }
//                }),
//                Observable.interval(1, TimeUnit.SECONDS).map(new Function<Long, String>() {
//                    @Override
//                    public String apply(Long aLong) throws Exception {
//                        return "B" + aLong;
//                    }
//                }))
//                .subscribe(new Observer<String>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(String s) {
//                        System.out.println("merge onNext" + s);
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });

        Observable.merge(
                Observable.interval(500, TimeUnit.MILLISECONDS).map(new Function < Long, String > () {
                    @Override
                    public String apply(Long aLong) throws Exception {
                        return "A" + aLong;
                    }
                }),
                Observable.interval(500, TimeUnit.MILLISECONDS).map(new Function < Long, String > () {
                    @Override
                    public String apply(Long aLong) throws Exception {
                        return "B" + aLong;
                    }
                }))
                .subscribe(new Observer < String > () {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {
                        System.out.println("s = " + s);
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
