package com.zjh.javademo.di.complex;

import javax.inject.Inject;

public class CompleCar {

    public CompleCar(){

        DaggerCompleCarComponent.builder().makeCarModule(new MakeCarModule()).build().inject(this);
    }

    @Inject
    CompleEngine compleEngine;

    public CompleEngine getCompleEngine(){
        return this.compleEngine;
    }
    public static void main(String[] args) {
        CompleCar car = new CompleCar();
        car.getCompleEngine().run();

    }

}
