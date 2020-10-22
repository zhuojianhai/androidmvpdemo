package com.zjh.javademo.pattern.observer;

public class BaiduSite implements IObserver {
    // 温度，气压，湿度
    private float temperature;
    private float pressure;
    private float humidity;
    //更新 天气情况，是由 WeatherData 来调用，我使用推送模式
    public void update(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        display();
    }

    public void display(){
        System.out.println("***Baiduwebsit Today mTemperature: " + temperature + "***");
        System.out.println("***Baiduwebsit Today mPressure: " + pressure + "***");
        System.out.println("***Baiduwebsit Today mHumidity: " + humidity + "***");
        System.out.println();
    }
}
