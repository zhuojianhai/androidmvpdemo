package com.zjh.javademo.di.named;

import javax.inject.Inject;
import javax.inject.Named;

public class TestDog {
    public TestDog(){

        DaggerDogComponent.create().injectToTest(this);
        DaggerDogComponent.builder().build().injectToTest(this);
    }

    @Named("tag_1")
    @Inject
    Dog dogA;

    @Named("tag_2")
    @Inject
    Dog dogB;

    public static void main(String[] args) {
        TestDog d = new TestDog();
//        d.dogA.getType();
        System.out.println(d.dogB.getType());
        System.out.println(d.dogA.getType());

    }
}
