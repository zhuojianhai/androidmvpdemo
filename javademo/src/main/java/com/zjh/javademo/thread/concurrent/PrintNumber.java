package com.zjh.javademo.thread.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class PrintNumber {
    private  int maxNumber = 100;
    private  AtomicInteger max = new AtomicInteger(1);


    //方式一
    public void print(int type){
        if (type ==1){//打印奇数
            while (max.get()<=maxNumber){
                synchronized (PrintNumber.class){
                    if (max.get() <= maxNumber &&  max.get()%2!=0){
                        System.out.println(Thread.currentThread().getName()+" 奇数为："+max.getAndIncrement());
                    }
                }

            }
        }else {
            while (max.get()<=maxNumber){
                synchronized (PrintNumber.class){
                    if (max.get() <= maxNumber &&  max.get()%2==0){
                        System.out.println(Thread.currentThread().getName()+"偶数为："+max.getAndIncrement());
                    }
                }

            }


        }
    }

    //方式二
    class MyPrintRunnable implements Runnable{
        private String name;
        private int type;
        public MyPrintRunnable(String name,int type){
            this.name = name;
            this.type = type;
        }

        @Override
        public void run() {
            if (type ==1){//打印奇数
                while (max.get()<=maxNumber){
                    synchronized (PrintNumber.class){
                        if (max.get() <= maxNumber &&  max.get()%2!=0){
                            System.out.println(Thread.currentThread().getName()+" 奇数为："+max.getAndIncrement());
                        }
                    }

                }
            }else {
                while (max.get()<=maxNumber){
                    synchronized (PrintNumber.class){
                        if (max.get() <= maxNumber &&  max.get()%2==0){
                            System.out.println(Thread.currentThread().getName()+"偶数为："+max.getAndIncrement());
                        }
                    }

                }


            }
        }
    }


    public static void main(String[] args) {
        PrintNumber printNumber = new PrintNumber();
//        ExecutorService executorService = Executors.newFixedThreadPool(2);
//
//        executorService.submit(printNumber.new MyPrintRunnable("thread1" ,1));
//        executorService.submit(printNumber.new MyPrintRunnable("thread2" ,2));
//
//
//        executorService.shutdown();
//        new Thread(printNumber.new MyPrintRunnable("thread1" ,1)).start();
//        new Thread(printNumber.new MyPrintRunnable("thread2" ,2)).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                printNumber.print(1);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                printNumber.print(2);
            }
        }).start();
    }
}
