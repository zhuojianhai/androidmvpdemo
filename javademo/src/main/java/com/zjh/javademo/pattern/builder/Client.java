package com.zjh.javademo.pattern.builder;

/**
 * 构造者4个角色：
 * Product：产品角色，一个具体的产品对象
 * Builder:抽象建造者，创建一个Product对象的各个部件指定的接口/抽象类
 * ConcreteBuilder:具体建造者，实现接口，构建和装配各个部件
 * Director：构建一个使用Builder接口的对象。它主要是用于创建一个复杂的对象。
 *          它主要有两个作用，一是：隔离了客户与对象的生产过程；二是：负责控制产品对象的生产过程。
 */
public class Client {
    public static void main(String[] args) {
        HouseDirector director = new HouseDirector();
        HouseBuilder builder = new CommonHouseBuilder();
        director.setHouseBuilder(builder);

        House house = director.buildHouse();
        System.out.println(house.toString());
    }
}
