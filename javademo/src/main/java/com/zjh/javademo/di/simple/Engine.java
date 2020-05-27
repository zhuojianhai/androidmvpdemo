package com.zjh.javademo.di.simple;

import javax.inject.Inject;

public class Engine {
    @Inject
    public Engine(){

    }

    public void run(){
        System.out.println("engine is running...");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
