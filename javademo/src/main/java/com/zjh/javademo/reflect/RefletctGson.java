package com.zjh.javademo.reflect;

import com.google.gson.Gson;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class RefletctGson {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz = Gson.class;
        //获得Gson类的所有构造方法，并打印
       Constructor[] constructors =  clazz.getDeclaredConstructors();
       for (Constructor c:constructors){

           System.out.println(c);
       }

       //使用无参数构造方法创建 Gson对象
      Constructor defaultConstruct =  clazz.getDeclaredConstructor(new Class[]{});
       Gson gObject = (Gson) defaultConstruct.newInstance(new Object[]{});

        System.out.println(gObject);
    }
}
