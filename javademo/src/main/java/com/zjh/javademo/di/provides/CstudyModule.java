package com.zjh.javademo.di.provides;

import dagger.Module;
import dagger.Provides;

@Module
public class CstudyModule {
    private  int momey;
    private String name;

    public CstudyModule(int momey,String name){
        this.momey = momey;
        this.name = name;
    }

    @Provides
    Soul provideSoul(){
        Soul soul = new Soul();
        soul.setMomey(momey);
        soul.setName(name);
        return  soul;
    }

    @Provides
    Woman provideWoman(Soul soul){
        Woman woman = new Woman(soul);
        return woman;

    }
}
