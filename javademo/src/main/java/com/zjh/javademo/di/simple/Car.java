package com.zjh.javademo.di.simple;

import javax.inject.Inject;

public class Car {
    public Car(){
        /**
         *将依赖和被依赖关联
         * 也就是将Engine 对象 inject 到car
         * 通过inject（this）
         */

        DaggerCarComponent.builder().build().inject(this);
    }
    @Inject
    Engine engine;

    public static void main(String args[]){
        Car car = new Car();
        car.engine.run();

    }
}
