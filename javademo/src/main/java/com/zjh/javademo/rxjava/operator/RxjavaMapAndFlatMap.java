package com.zjh.javademo.rxjava.operator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;

public class RxjavaMapAndFlatMap {
    public static void main(String[] args) {
        showFlatMap();
    }

    private static void shwoMap() {

    }

    /**
     * map和flatMap区别
     * map和flatMap都是依赖传入的Function对数据进行变换
     * 但是区别如下：
     * 1、返回值上面：
     * map变换后可以返回任意值，而flatMap则只能返回ObservableSource类型
     * 2、变换后的输出：
     * map只能进行一对一的变换，
     * 而flatMap则可以进行一对一，
     * 一对多，
     * 多对多的变换，具体的变换规则根据我们设置的变换函数mapper来定
     * 版权声明：本文为CSDN博主「new_abc」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
     * 原文链接：https://blog.csdn.net/new_abc/article/details/84318464
     */
    private static void showFlatMap() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i + "");
        }

        /**
         * 1对1的转换
         */
        Observable.just(list)
                .flatMap(new Function<List<String>, ObservableSource<List<String>>>() {
                    @Override
                    public ObservableSource<List<String>> apply(List<String> strings) throws Exception {
                        List<String> newList = new ArrayList<>();
                        for (String s : strings) {
                            newList.add(s + " =======");
                        }
                        return Observable.fromArray(newList);
                    }
                }).subscribe(new Observer<List<String>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<String> strings) {
                System.out.println(strings.toString());

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

        System.out.println("========开始一对多================");

        /**
         * 1对多
         */
        Observable.just(list)
                .flatMap(new Function<List<String>, ObservableSource<String>>() {
                    @Override
                    public ObservableSource<String> apply(List<String> strings) throws Exception {
                        return Observable.fromIterable(strings);
                    }
                }).subscribe(new Observer<String>() {
            StringBuffer sb = new StringBuffer();

            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {
                sb.append(s + "   ");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

                System.out.println(sb.toString());
            }
        });

        System.out.println("=========开始多对多====");
        Observable.just("list1", "list2", "list3", "list4")
                .flatMap(new Function<String, ObservableSource<List<String>>>() {
                    @Override
                    public ObservableSource<List<String>> apply(String s) throws Exception {
                        List<String> list1 = new ArrayList<>();
                        list1.add(s + " vaule");
                        return Observable.just(list1);
                    }
                })
                .filter(new Predicate<List<String>>() {
                        @Override
                        public boolean test(List<String> strings) throws Exception {

                            return true;
                        }
                     })
                .throttleFirst(500, TimeUnit.MILLISECONDS)
                .doOnNext(new Consumer<List<String>>() {
                    @Override
                    public void accept(List<String> strings) throws Exception {
                        System.out.println("doOnNext-----"+strings);
                    }
                })

                .doFinally(new Action() {
                    @Override
                    public void run() throws Exception {
                        System.out.println("doFinally-----------");
                    }
                })
                .doOnComplete(new Action() {
                    @Override
                    public void run() throws Exception {
                        System.out.println("doOnComplete-----------------");
                    }
                })
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        System.out.println("doOnSubscribe-----------------");
                    }
                })
                .subscribe(new Observer<List<String>>() {
                    StringBuffer sb = new StringBuffer();

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<String> strings) {
                        sb.append(strings.toString() + "==" + strings.size() + "# ");

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        System.out.println(sb.toString());
                    }
                });
    }

}
