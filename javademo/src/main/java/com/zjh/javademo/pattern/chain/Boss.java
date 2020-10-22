package com.zjh.javademo.pattern.chain;

public class Boss extends AbstractHandler {

    @Override
    public boolean proceed(int value) {
        if(value>10000){
            System.out.println("boss  无权审批，需要bosswife审批");
            handler.proceed(value);
        }else{
            System.out.println("boss  end......");
        }

        System.out.println("Boss end......");
        return false;
    }
}
