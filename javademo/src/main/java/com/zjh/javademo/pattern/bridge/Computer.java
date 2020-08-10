package com.zjh.javademo.pattern.bridge;

public abstract  class Computer {
    protected Brand brand;
    public Computer(){
        super();
    }
    public Computer(Brand brand){
        this.brand = brand;
    }

    public void sale(){
        brand.sale();
    }
}
