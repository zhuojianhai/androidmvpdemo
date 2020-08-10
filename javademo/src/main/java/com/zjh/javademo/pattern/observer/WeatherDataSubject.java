package com.zjh.javademo.pattern.observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherDataSubject implements ISubject {

    protected List<IObserver>  subjectsContainer = new ArrayList<>();

    private float temperatrue;
    private float pressure;
    private float humidity;


    @Override
    public void registerObserver(IObserver observer) {
                subjectsContainer.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {
        subjectsContainer.remove(observer);

    }

    @Override
    public void notifyAllObserver() {

        for (IObserver o :
                subjectsContainer) {

            o.update(this.temperatrue,this.pressure,this.humidity);
        }
    }

    public void setData(float temperatrue,float pressure,float humidity){
        this.temperatrue = temperatrue;
        this.pressure = pressure;
        this.humidity = humidity;

        dataChangeNotify();

    }

    public void dataChangeNotify(){
        notifyAllObserver();
    }
}
