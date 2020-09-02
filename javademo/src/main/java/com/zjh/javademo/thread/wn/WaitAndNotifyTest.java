package com.zjh.javademo.thread.wn;

import java.util.LinkedList;

public class WaitAndNotifyTest {
    public static void main(String[] args) {
        FruitJuiceMaker fruitJuiceMaker = new FruitJuiceMaker();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                    while (true) {
                        LinkedList<FruitJuice> fruitJuiceLinkedList = fruitJuiceMaker.productFruitJuice();
                    }
            }
        },"Thread 1");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                    try {
                        Thread.sleep(3000);
                        while (true && !Thread.currentThread().isInterrupted()){
                            fruitJuiceMaker.drinkFruitJuice();
                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        Thread.currentThread().interrupt();
                    }


            }
        },"Thread 2");

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    while (true && !Thread.currentThread().isInterrupted()){
                        fruitJuiceMaker.drinkFruitJuice();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }

            }
        },"Thread 3");



        thread1.start();

        thread2.start();
        thread3.start();
    }
}
