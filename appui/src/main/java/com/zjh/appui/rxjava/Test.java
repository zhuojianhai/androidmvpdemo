package com.zjh.appui.rxjava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) {
        showAsynchronized();
        showInfo();
    }

    private static void showAsynchronized(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                showInfo();
            }
        }).start();

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                //在新的綫程中执行
              showInfo();
            }
        });
        executorService.shutdown();
    }
    private static void showInfo(){
        System.out.println(Thread.currentThread().getName());
    }
}
