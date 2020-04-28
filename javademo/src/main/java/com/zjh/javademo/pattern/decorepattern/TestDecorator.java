package com.zjh.javademo.pattern.decorepattern;

/**
 * 装饰器：给一个对象动态的增加一些额外的功能
 *
 * 1、抽象装饰器对象
 */
public class TestDecorator {
    public static void main(String[] args) {
        Person employee = new Employee();
        Person p = new ManagerA(employee);
        p.doSomething();

    }
}
