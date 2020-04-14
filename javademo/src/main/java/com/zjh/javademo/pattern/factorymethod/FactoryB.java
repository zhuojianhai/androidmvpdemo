package com.zjh.javademo.pattern.factorymethod;

public class FactoryB extends Factory {
    @Override
    public Product Manufacture() {
        return new ProductB();
    }
}
