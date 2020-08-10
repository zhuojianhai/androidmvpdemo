package com.zjh.javademo.pattern.chain;

public class BossWife extends AbstractHandler {
    @Override
    public boolean proceed(int value) {
        if (value> 20000){
            System.out.println("败家啊，不通过");
            return false;
        }
        System.out.println("终极boss老板娘审批通过!");
        return false;
    }
}
