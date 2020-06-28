package com.example.myapplication.dagger2.di;

import com.example.myapplication.dagger2.ui.DaggerMenuActivity;

import java.util.Map;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = CookModules.class)
public interface CookComponent {
    void inject(DaggerMenuActivity daggerMenuActivity);

    @Component.Builder
    interface Builder{
        CookComponent build();
    }
}
