package com.zjh.javademo.generic;

public class ContainerC<T extends Fruit> {
    private T  data;
    public ContainerC(){

    }

    public ContainerC(T  data){
        this.data = data;
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
