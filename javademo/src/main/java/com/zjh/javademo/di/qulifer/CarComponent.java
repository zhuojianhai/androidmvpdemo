package com.zjh.javademo.di.qulifer;

import dagger.Component;

@Component(modules = MakeCarModule.class)
public interface CarComponent {
    void inject(Car car);

}
