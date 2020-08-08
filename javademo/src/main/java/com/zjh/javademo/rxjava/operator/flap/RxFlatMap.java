package com.zjh.javademo.rxjava.operator.flap;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

public class RxFlatMap {

    public static void main(String[] args) {
        RxFlatMap flatMap = new RxFlatMap();
        flatMap.showMap();
        flatMap.showFlatMap();
    }

    private void showMap(){

        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {//代码运行起来，第二个被执行的方法
                emitter.onNext("next value");

            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {//代码运行起来，第一个被执行的方法

            }

            @Override
            public void onNext(String s) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    private void showFlatMap(){
        List<Person> list = new ArrayList<>();
        for (int i=0;i<10;i++){
            Person person = new Person();
            person.setName(i+"");
            List<Plan> planList = new ArrayList<>();
            Plan p = new Plan();
            p.setTime(new Date().toString());
            p.setContent("haha");
            p.getActionList().add("actionlist value is "+i);
            planList.add(p);
            person.setPlanList(planList);

            list.add(person);
        }
        // fromArray 必须是个数组
        Person[] people = (Person[]) list.toArray();
        Observable.fromArray(people).flatMap(new Function<Person, ObservableSource<Plan>>() {
            @Override
            public ObservableSource<Plan> apply(Person person) throws Exception {
                return null;
            }
        });


        //fromIterable 必须是实现了Iterable接口的类
        Observable.fromIterable(list)
                .flatMap(new Function<Person, ObservableSource<Plan>>() {
                    @Override
                    public ObservableSource<Plan> apply(Person person) throws Exception {
                        return Observable.fromIterable(person.getPlanList());
                    }
                })
                .flatMap(new Function<Plan, ObservableSource<String>>() {
                    @Override
                    public ObservableSource<String> apply(Plan plan) throws Exception {
                        return Observable.fromIterable(plan.getActionList());
                    }
                }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println("action sheet value is "+s);

            }
        });
    }



}
