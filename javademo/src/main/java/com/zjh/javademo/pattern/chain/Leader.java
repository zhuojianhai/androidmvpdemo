package com.zjh.javademo.pattern.chain;

public class Leader extends AbstractHandler {

    @Override
    public boolean proceed(int value) {
        if(value>100){
            System.out.println("leader 无权限审批，要经理审批");
            handler.proceed(value);
        }else{
            System.out.println("leader 审批通过");
        }
        System.out.println("leader end......");
        return false;
    }
}
