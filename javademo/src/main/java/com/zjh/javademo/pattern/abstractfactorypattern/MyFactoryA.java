package com.zjh.javademo.pattern.abstractfactorypattern;

public class MyFactoryA extends MyAbstractFactory {
    @Override
    public AbstractProduct createProductA(Class pClass) {
        try {
            return (AbstractProduct) pClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return  null;
    }

    @Override
    public AbstractProduct createProductB(Class pClass) {
        try {
            return (AbstractProduct) pClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return  null;
    }
}
