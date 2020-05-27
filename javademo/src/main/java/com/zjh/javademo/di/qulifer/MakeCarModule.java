package com.zjh.javademo.di.qulifer;

import dagger.Module;
import dagger.Provides;

@Module
public class MakeCarModule {
    public MakeCarModule(){

    }

    @Engine.QualifierA
    @Provides
    Engine provideEngineA(){
        return new Engine("EngineA");
    }

    @Engine.QualifierB
    @Provides
    Engine provideEngineB(){
        return new Engine("EngineB");
    }
}
