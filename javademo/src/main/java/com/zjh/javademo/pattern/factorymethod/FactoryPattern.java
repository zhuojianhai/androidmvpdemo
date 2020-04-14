package com.zjh.javademo.pattern.factorymethod;

public class FactoryPattern {
    public static void main(String[] args) {
        Factory factoryA = new FactoryA();
        factoryA.Manufacture().Show();


        factoryA = new FactoryB();
        factoryA.Manufacture().Show();



        FactoryPower fp = new FactoryPowerImp1();
        ProductInterface pi =    fp.createProduct(ProductInterfaceImp1.class);
        String pName =  pi.productName();
        System.out.println(pName);

    }
}
