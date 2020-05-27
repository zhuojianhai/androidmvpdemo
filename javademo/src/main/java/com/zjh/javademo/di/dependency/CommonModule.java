package com.zjh.javademo.di.dependency;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class CommonModule {

    @Singleton
    @Provides
    public Book provideBook(){
        return  new Book("fullter",100.8);
    }
}
