package com.zjh.javademo.di.qulifer;

import javax.inject.Inject;

public class Car {
    @Inject
    @Engine.QualifierA
    Engine engineA;

   @Engine.QualifierB
    @Inject
    Engine engineB;

    public Engine getEngineA() {
        return this.engineA;
    }


    public Engine getEngineB() {
        return this.engineB;
    }

    public Car(){

    DaggerCarComponent.builder().makeCarModule(new MakeCarModule()).build().inject(this);
    }

    public static void main(String[] args) {
        Car car = new Car();

        car.getEngineA().run();
        car.getEngineB().run();

        System.out.println(car.getEngineA());
        System.out.println(car.getEngineB());

    }

}
