package com.zjh.javademo.pattern.builder;

public abstract class HouseBuilder {
    protected House house = new House();
    /**
     * 将建造的流程写好，抽象的方法
     */
    public abstract void buildBasic();
    public abstract void buildWalls();
    public abstract void roofed();

    public House buidHouse(){
        return  house;
    }
}
