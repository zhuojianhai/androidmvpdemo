package com.zjh.javademo.di.provides;

import javax.inject.Inject;

public class Test {
    public Test(){
        DaggerCstudyComponent.builder().cstudyModule(new CstudyModule(100,"zhuojianhai")).build().inject(this);
    }
    @Inject
    Woman woman;

    public static void main(String[] args) {

        Test test = new Test();
        System.out.println(test.woman);
        test.woman.show();
    }
}
