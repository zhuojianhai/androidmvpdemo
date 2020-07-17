package com.zjh.javademo.rxjava.myrxjava;

/**
 * 具体的数据发射器
 * @param <T>
 */
public class MyEmitterCreate<T> implements MyEmitter<T> {

    MyObserver<T> observer;
    public MyEmitterCreate(){
        super();
    }
    public MyEmitterCreate(MyObserver<T> observer){
        this.observer = observer;
    }

    @Override
    public void onNext(T o) {
        observer.onNext(o);

    }

    @Override
    public void onError() {

    }
}
