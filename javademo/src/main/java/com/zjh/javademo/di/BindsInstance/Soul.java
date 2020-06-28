package com.zjh.javademo.di.BindsInstance;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Soul {
    private int momey;
    private String name;
    public Soul(){
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getMomey() {
        return momey;
    }
    public void setMomey(int momey) {
        this.momey = momey;
    }
    @Override
    public String toString() {
        return "Soul{" + "momey=" + momey + ", name='" + name + '\'' + '}';
    }

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Soul> clzz = Soul.class;
        Constructor[] constructors = clzz.getDeclaredConstructors();
        for (Constructor c:constructors){
            System.out.println("构造函数为:"+c);
            Soul o = (Soul) c.newInstance(new Object[]{});
            o.setMomey(100);
            o.setName("zhuojianhai");
            System.out.println(o.toString());
        }
    }
}
