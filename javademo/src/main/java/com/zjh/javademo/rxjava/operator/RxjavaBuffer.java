package com.zjh.javademo.rxjava.operator;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class RxjavaBuffer {
    public static void main(String[] args) {

        RxjavaBuffer buffer = new RxjavaBuffer();
        buffer.showBuffer();
    }

    private void showBuffer(){
        Observable.just(1,2,3,4,5)
                .buffer(2,1)
                .subscribe(new Observer<List<Integer>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<Integer> integers) {
                        System.out.println("------缓冲区大小"+integers.size());
                        for (Integer i: integers) {
                            System.out.println("================元素： " + i);
                        }

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
