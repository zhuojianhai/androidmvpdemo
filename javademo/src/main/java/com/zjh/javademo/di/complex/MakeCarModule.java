package com.zjh.javademo.di.complex;

import dagger.Module;
import dagger.Provides;

@Module
public class MakeCarModule {
    public MakeCarModule(){

    }

    @Provides
    public CompleEngine provideEngine(){
        return  new CompleEngine("compleEngine");
    }
}
