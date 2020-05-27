package com.zjh.javademo.di.component_dependence;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    @Provides
    Human provideHuma(){
        return  new Human("建海");
    }



}
