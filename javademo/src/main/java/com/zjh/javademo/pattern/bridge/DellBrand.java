package com.zjh.javademo.pattern.bridge;

public class DellBrand implements Brand {
    @Override
    public void sale() {
        System.out.println("this is DellBrand sale");
    }
}
