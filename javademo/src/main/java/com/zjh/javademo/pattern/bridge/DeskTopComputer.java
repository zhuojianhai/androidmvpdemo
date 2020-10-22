package com.zjh.javademo.pattern.bridge;

public class DeskTopComputer extends Computer {
    public DeskTopComputer(Brand brand){
        super(brand);
    }

    @Override
    public void sale() {
        super.sale();
        System.out.println("电脑类型为台式");
    }
}
