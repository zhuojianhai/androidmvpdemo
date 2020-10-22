package com.zjh.javademo.pattern.builder;

public class HighHouseBuilder extends HouseBuilder {
    @Override
    public void buildBasic() {
        System.out.println(" 高楼的打地基100米 ");
    }

    @Override
    public void buildWalls() {
        System.out.println(" 高楼的砌墙50米 ");
    }

    @Override
    public void roofed() {
        System.out.println(" 高楼的透明的屋顶 ");
    }
}
