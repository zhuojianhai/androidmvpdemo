package com.zjh.javademo.thread.wn;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class FruitJuiceMaker {
    private LinkedList<FruitJuice> fruitJuiceLinkedList = new LinkedList<>();
    AtomicInteger currentSize = new AtomicInteger();

    public synchronized LinkedList<FruitJuice> productFruitJuice(){
        while (fruitJuiceLinkedList.isEmpty()){
            for (int i=0;i<10;i++){
                FruitJuice fruitJuice = new FruitJuice("苹果",i);
                fruitJuiceLinkedList.addLast(fruitJuice);
            }

            System.out.println("fruitJuiceLinkedList===== "+fruitJuiceLinkedList.size());

            currentSize.set(fruitJuiceLinkedList.size());

            notifyAll();

            System.out.println(Thread.currentThread().getName()+" 新生产果汁为：" + fruitJuiceLinkedList.toString());
        }
        return fruitJuiceLinkedList;
    }

    public synchronized FruitJuice drinkFruitJuice() throws InterruptedException {

        while (fruitJuiceLinkedList.isEmpty()){
            System.out.println(Thread.currentThread().getName()+"  等待生产果汁中....");
            wait();
        }
        FruitJuice fruitJuice = fruitJuiceLinkedList.removeFirst();
        System.out.println(Thread.currentThread().getName()+"   得到果汁为： "+fruitJuice.toString());
        return fruitJuice;

    }
}
