package com.zjh.javademo.di.named;

import dagger.Component;

@Component(modules = DogModule.class)
public interface DogComponent {
    void injectToTest(TestDog testDog);
}
