package com.zjh.javademo.rxjava.operator.from;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

public class RxjavaFrom {
    public static void main(String[] args) {

    }
    private Observable<List<String>> showFrom(){
        List<String> list = new ArrayList<>();
        list.add("代理商关键是两个");
        list.add("代理商关键是两个");
        list.add("代理商关键是两个");
        list.add("代理商关键是两个");
        list.add("代理商关键是两个");
        list.add("代理商关键是两个");
        list.add("代理商关键是两个");

      return  null;
    }
}
