package com.zjh.javademo.generic;

public class TestGeneric {
    public static void main(String[] args) {

        ContainerC<Fruit> c = new ContainerC<>();
        c.setData(new Apple());
        c.setData(new RedApple());
        c.setData(new Fruit());

        c.setData(new Orange());

    }
}
