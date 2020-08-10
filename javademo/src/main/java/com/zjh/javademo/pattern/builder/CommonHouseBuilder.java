package com.zjh.javademo.pattern.builder;

public class CommonHouseBuilder extends HouseBuilder {
    @Override
    public void buildBasic() {
        System.out.println(" 普通房子打地基8米 ");
    }

    @Override
    public void buildWalls() {
        System.out.println("  普通房子砌墙8cm  ");

    }

    @Override
    public void roofed() {
        System.out.println(" 普通房子盖屋顶 ");
    }
}
