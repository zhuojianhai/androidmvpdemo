package com.zjh.javademo.pattern.bridge;

public class LaptopComputer extends Computer {
    public LaptopComputer(Brand brand){
        super(brand);
    }

    @Override
    public void sale() {
        super.sale();
        System.out.println("电脑类型为手提式");
    }
}
