package com.zjh.javademo.rxjava.myrxjava;

/**
 * 具体的被观察者
 * @param <T>
 */
public class MyObservableCreate<T> extends MyObservable {
    MyObservableOnSubscribe<T>  myObservableOnSubscribe;
    public MyObservableCreate( MyObservableOnSubscribe<T>  myObservableOnSubscribe){
        this.myObservableOnSubscribe = myObservableOnSubscribe;
    }
    @Override
    public void subscribeActual(MyObserver observer) {
        //创建发射器
        MyEmitterCreate<T> emitterCreate = new MyEmitterCreate<>(observer);
        //回调observer的 onSubscribe()
        observer.onSubscribe();
        //回调上一个的subscribe
        myObservableOnSubscribe.subscribe(emitterCreate);

    }
}
