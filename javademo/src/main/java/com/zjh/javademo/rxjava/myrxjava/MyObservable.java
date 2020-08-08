package com.zjh.javademo.rxjava.myrxjava;

/**
 * 抽象的被观察者
 * @param <T>
 */
public abstract class MyObservable<T> {

    public static <T> MyObservableCreate<T> create(MyObservableOnSubscribe<T> observableOnSubscribe) {
        return new MyObservableCreate<T>(observableOnSubscribe);
    }

    public void subscribe(MyObserver<T> observer) {
        subscribeActual(observer);
    }

    public abstract void subscribeActual(MyObserver<T> observer);

}
