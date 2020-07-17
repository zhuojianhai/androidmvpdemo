package com.zjh.javademo.rxjava.myrxjava;

/***
 * 数据观察者
 * @param <T>
 */
public interface MyObserver<T> {
    void onSubscribe();
    void onNext(T t);
    void onError();
    void onComplete();
}
