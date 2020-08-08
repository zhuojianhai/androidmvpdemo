package com.zjh.javademo.rxjava.operator.custom;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;

public class RxjavaCustomTransfer {
    public static void main(String[] args) {
        RxjavaCustomTransfer r = new RxjavaCustomTransfer();
        r.showCustomTransfer();
    }

    private void showCustomTransfer(){
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                    for (int i=0;i<100;i++){
                        emitter.onNext("emitter value "+i);
                    }
            }
        }).compose(new NetWorkTransformer())
        .subscribe(new Consumer<String>() {
            @Override
            public void accept(String o) throws Exception {
                System.out.println(o);
            }
        });
    }
}
