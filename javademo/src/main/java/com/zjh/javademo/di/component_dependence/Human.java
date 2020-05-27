package com.zjh.javademo.di.component_dependence;

public class Human {
    public Human(){

    }
    private String name;
    public Human(String name){
        this.name = name;
    }

    public void showInfo(){
        System.out.println("this is showinfo method");
    }
}
