package com.zjh.javademo.pattern.abstractfactorypattern;

/**
 * 抽象工厂方法和工厂方法唯一区别，就是前者是创建多个对象，后者只能创建一个对象
 */
public class AbstractFactoryPattern {
    public static void main(String[] args) {

        MyAbstractFactory factoryA = new MyFactoryA();
        AbstractProduct productA = factoryA.createProductA(MyProductA.class);
        AbstractProduct productB = factoryA.createProductA(MyProductB.class);

        productA.showProductName();
        productB.showProductName();


    }
}
