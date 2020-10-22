package com.zjh.javademo.thread.concurrent;

import java.util.concurrent.CountDownLatch;

public class CountDownLaunchTest {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(2);

        new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println(Thread.currentThread().getName()+" 正在执行任务"+"======");
                for (int i=1;i<10;i++){
                    System.out.println(i%2==0?"":i);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+" 执行任务完成"+"======");

                countDownLatch.countDown();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println(Thread.currentThread().getName()+" 正在执行任务"+"======");
                for (int i=1;i<10;i++){
                    System.out.println(i%2==0?i:"");
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+" 执行任务完成"+"======");

                countDownLatch.countDown();
            }
        }).start();


        try {
            System.out.println(Thread.currentThread().getName()+"等待两个子线程任务执行完成");
            countDownLatch.await();
            System.out.println(Thread.currentThread().getName()+"两个子线程任务执行完成，该线程继续执行");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
