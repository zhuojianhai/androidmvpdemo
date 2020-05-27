package com.zjh.javademo.di.complex;

import javax.inject.Inject;

public class CompleEngine {
    private String name;

    public CompleEngine(){
    }
    @Inject
    public CompleEngine(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "CompleEngine{" +
                "name='" + name + '\'' +
                '}';
    }

    public void run() {
        System.out.println("引擎转起来了~~~");
    }
}
