package com.zjh.javademo.pattern.factorymethod;

public class FactoryPowerImp1 extends FactoryPower {
    @Override
    public ProductInterface createProduct(Class productClass) {
        try {
            return (ProductInterface) productClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
