package com.zjh.javademo.rxjava.operator;

import java.util.List;

import io.reactivex.ObservableOperator;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * 将list<String>类型转换成String类型数据
 */
public class CustomOperator implements ObservableOperator<String, List<String>> {
    @Override
    public Observer<? super List<String>> apply(Observer<? super String> observer) throws Exception {
        return new Observer<List<String>>() {
            @Override
            public void onSubscribe(Disposable d) {
                observer.onSubscribe(d);
            }

            @Override
            public void onNext(List<String> strings) {
                observer.onNext(strings.toString());

            }

            @Override
            public void onError(Throwable e) {
                observer.onError(e);

            }

            @Override
            public void onComplete() {

                observer.onComplete();
            }
        };
    }
}
