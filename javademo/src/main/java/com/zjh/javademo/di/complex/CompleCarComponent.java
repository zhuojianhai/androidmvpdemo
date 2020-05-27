package com.zjh.javademo.di.complex;

import dagger.Component;

@Component(modules = MakeCarModule.class)
public interface CompleCarComponent {

    void inject(CompleCar compleCar);
}
