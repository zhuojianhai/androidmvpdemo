package com.zjh.javademo.pattern.chain;

public class Manager extends AbstractHandler {

    @Override
    public boolean proceed(int value) {
        if(value>200){
            System.out.println("Manager 无权性审批，要boss审批");
            handler.proceed(value);
        }else{
            System.out.println("manager 审批通过");
        }

        System.out.println("Manager end......");
        return false;
    }
}
