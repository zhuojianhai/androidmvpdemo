package com.zjh.javademo.di.BindsInstance;

import javax.inject.Inject;

public class Test {
    public Test(){
        DaggerCstudyComponent.builder().initMoney(800).build().inject(this);
    }
    @Inject
    Woman woman;

    public static void main(String[] args) {

        Test test = new Test();
        System.out.println(test.woman);
        test.woman.show();
    }
}
