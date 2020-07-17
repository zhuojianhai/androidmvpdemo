package com.zjh.javademo.rxjava.myrxjava;

/**
 * 数据集发射器需要具有的功能
 * @param <T>
 */
public interface MyEmitter<T> {
    void onNext(T t);
    void onError();
}
