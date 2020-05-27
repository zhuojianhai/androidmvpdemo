package com.zjh.javademo.di.BindsInstance;

import dagger.Module;
import dagger.Provides;

@Module
public class CstudyModule {

    @Provides
    Soul provideSoul(int momey){
        Soul soul = new Soul();
        soul.setMomey(momey);
        return  soul;
    }

    @Provides
    Woman provideWoman(Soul soul){
        Woman woman = new Woman(soul);
        return woman;
    }
}
