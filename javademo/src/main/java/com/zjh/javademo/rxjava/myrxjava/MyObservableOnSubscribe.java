package com.zjh.javademo.rxjava.myrxjava;

/**
 * 当被观察者 被观察者订阅的时候，需要回调的对象
 * 数据的发射就是从 这里的MyEmitter开始
 *
 * 数据的发送，观察者就能得到数据
 * @param <T>
 */
public interface MyObservableOnSubscribe<T> {
    void subscribe(MyEmitter<T> emitter);
}
