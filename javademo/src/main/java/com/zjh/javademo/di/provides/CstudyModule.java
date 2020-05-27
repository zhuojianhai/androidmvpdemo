package com.zjh.javademo.di.provides;

import dagger.Module;
import dagger.Provides;

@Module
public class CstudyModule {
    private  int momey;

    public CstudyModule(int momey){
        this.momey = momey;
    }

    @Provides
    Soul provideSoul(){
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
