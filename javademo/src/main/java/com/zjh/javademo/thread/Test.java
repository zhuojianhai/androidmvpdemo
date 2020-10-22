package com.zjh.javademo.thread;

public class Test {
    public static void main(String[] args) {
   Thread t =      new Thread(new Runnable() {
            @Override
            public void run() {
                int i=0;
                while (true){
                    if (i>100000) return;
                    System.out.println("current i is "+ i);
                    i++;
                }
            }
        });

        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程执行完成");

    }
}
