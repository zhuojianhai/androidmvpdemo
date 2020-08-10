package com.zjh.javademo.pattern.observer;


public class Client {
    public static void main(String[] args) {
        WeatherDataSubject observable = new WeatherDataSubject();
        IObserver observer = new CurrentConditions();


        observable.registerObserver(observer);
        observer = new BaiduSite();
        observable.registerObserver(observer);
        observable.setData(10f,11f,12f);

    }
}
