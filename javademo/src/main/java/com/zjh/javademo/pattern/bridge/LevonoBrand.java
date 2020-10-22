package com.zjh.javademo.pattern.bridge;

public class LevonoBrand implements Brand {
    @Override
    public void sale() {
        System.out.println("this is LevonoBrand sale");
    }
}
