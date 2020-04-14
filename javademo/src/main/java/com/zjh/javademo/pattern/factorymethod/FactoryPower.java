package com.zjh.javademo.pattern.factorymethod;

public abstract class FactoryPower<T> {

    public abstract ProductInterface createProduct(Class<T> productClass);
}
