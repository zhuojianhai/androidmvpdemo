package com.zjh.javademo.pattern.abstractfactorypattern;

public class MyProductA implements AbstractProduct {
    @Override
    public void showProductName() {
        System.out.println("this is MyProductA ");
    }
}
