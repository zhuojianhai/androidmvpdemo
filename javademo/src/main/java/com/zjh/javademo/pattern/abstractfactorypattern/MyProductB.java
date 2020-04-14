package com.zjh.javademo.pattern.abstractfactorypattern;

public class MyProductB implements AbstractProduct {
    @Override
    public void showProductName() {
        System.out.println("this is MyProductB");
    }
}
