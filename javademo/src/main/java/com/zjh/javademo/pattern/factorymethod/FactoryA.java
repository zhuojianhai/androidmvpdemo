package com.zjh.javademo.pattern.factorymethod;

public class FactoryA extends Factory {
    @Override
    public Product Manufacture() {
        return new ProductA();
    }
}
