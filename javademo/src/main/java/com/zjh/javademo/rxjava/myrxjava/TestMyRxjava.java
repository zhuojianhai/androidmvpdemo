package com.zjh.javademo.rxjava.myrxjava;

public class TestMyRxjava {
    public static void main(String[] args) {
        MyObservable.create(new MyObservableOnSubscribe<String>() {
            @Override
            public void subscribe(MyEmitter<String> emitter) {
                emitter.onNext("this is 自定义的rxjava");

            }
        }).subscribe(new MyObserver<String>() {
            @Override
            public void onSubscribe() {

            }

            @Override
            public void onNext(String o) {
                System.out.println("o = " + o);

            }

            @Override
            public void onError() {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}
