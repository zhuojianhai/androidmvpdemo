package com.zjh.javademo.di.simple;

import dagger.BindsInstance;
import dagger.Component;

@Component
public interface CarComponent {
    void inject(Car car);
//    @Component.Builder
//    interface Builder {
//        @BindsInstance
//        CarComponent build();
//    }

}
