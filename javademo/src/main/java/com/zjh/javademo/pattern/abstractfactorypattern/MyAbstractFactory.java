package com.zjh.javademo.pattern.abstractfactorypattern;

/**
 * 定义抽象工厂类
 */
public abstract class MyAbstractFactory {
    public abstract  AbstractProduct  createProductA(Class pClass);
    public abstract  AbstractProduct  createProductB(Class pClass);
}
