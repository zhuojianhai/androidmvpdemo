package com.zjh.javademo.pattern.observer;

/**
 * 具体观察者
 */
public class CurrentConditions implements IObserver {
    private float temperatrue;
    private float pressure;
    private float humidity;

    @Override
    public void update(float temperatrue, float pressure, float humidity) {
        this.temperatrue = temperatrue;
        this.pressure = pressure;
        this.humidity = humidity;
        display();

    }

    public void display(){
        System.out.println("***Today mTemperature: " + temperatrue + "***");
        System.out.println("***Today mPressure: " + pressure + "***");
        System.out.println("***Today mHumidity: " + humidity + "***");
        System.out.println();
    }
}
