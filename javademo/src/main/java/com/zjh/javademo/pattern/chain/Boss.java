package com.zjh.javademo.pattern.chain;

public class Boss extends AbstractHandler {

    @Override
    public boolean proceed(int value) {
        if(value>10000){
            System.out.println("boss  审批不通过");
            return false;
        }

        System.out.println("boss  审批通过");
        return false;
    }
}
