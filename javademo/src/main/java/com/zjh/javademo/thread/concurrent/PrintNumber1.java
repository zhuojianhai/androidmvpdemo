package com.zjh.javademo.thread.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class PrintNumber1 {
    private  int maxNumber = 100;
    private  AtomicInteger max = new AtomicInteger(1);

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
                    synchronized (PrintNumber1.class){
                        if (max.get() <= maxNumber &&  max.get()%2!=0){
                            System.out.println(Thread.currentThread().getName()+" 奇数为："+max.getAndIncrement());
                        }
                    }

                }
            }else {
                while (max.get()<=maxNumber){
                    synchronized (PrintNumber1.class){
                        if (max.get() <= maxNumber &&  max.get()%2==0){
                            System.out.println(Thread.currentThread().getName()+"偶数为："+max.getAndIncrement());
                        }
                    }

                }


            }
        }
    }


    public static void main(String[] args) {
        PrintNumber1 printNumber = new PrintNumber1();
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(printNumber.new MyPrintRunnable("thread1" ,1));
        executorService.submit(printNumber.new MyPrintRunnable("thread2" ,2));


        executorService.shutdown();
    }
}
