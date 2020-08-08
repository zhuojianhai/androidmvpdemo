package com.zjh.javademo.rxjava.operator;

import java.io.File;
import java.nio.charset.Charset;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;

public class RxjavaApply {
    public static void main(String[] args) {

//        String filePath = "D:\\projects\\selfandroid-projects\\Aidlprojects\\javademo\\src\\main\\java\\com\\zjh\\javademo\\rxjava\\operator\\RxjavaMapAndFlatMap.java";
//        getFile(filePath)
//        .subscribe(new Consumer<File>() {
//            @Override
//            public void accept(File file) throws Exception {
//                System.out.println(file.getAbsolutePath());
//                System.out.println(file.getName());
//            }
//        });
//
//
//        System.out.println("-----------------------开始读取文件的内容---------------------------------");
//        getFile(filePath)
//                .map(new Function<File, String>() {
//                    @Override
//                    public String apply(File file) throws Exception {
//                        String result = "";
//                        BufferedSource bufferedSource = null;
//                        try{
//                            Source source = Okio.source(file);
//                             bufferedSource = Okio.buffer(source);
//                            result =   bufferedSource.readString(Charset.forName("UTF-8"));
//                        }finally {
//                            if(null!=bufferedSource){
//                                bufferedSource.close();
//                            }
//
//                        }
//
//
//                        return result;
//                    }
//                }).subscribe(new Consumer<String>() {
//            @Override
//            public void accept(String s) throws Exception {
//                System.out.println(s);
//            }
//        });

        RxjavaApply rxjavaApply = new RxjavaApply();
        rxjavaApply.ss();
    }

    /***
     * 读取文件
     * @param filePath
     * @return
     */
    private static Observable<File> getFile(String filePath){
      return   Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext(filePath);
            }
        }).flatMap(new Function<String, ObservableSource<File>>() {
            @Override
            public ObservableSource<File> apply(String s) throws Exception {
                File file = new File(s);
                return Observable.just(file);

            }
        });
    }

    private void ss(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                System.out.println("事件分发过程");
                            }
                        }).start();

                    }
                }).start();
            }
        }).start();
    }
}
