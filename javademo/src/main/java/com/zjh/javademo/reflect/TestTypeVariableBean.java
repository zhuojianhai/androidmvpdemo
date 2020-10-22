package com.zjh.javademo.reflect;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public class TestTypeVariableBean<K extends Number,T> {
    //K有指定了上边界Number
    K key;
    //T 没有指定的上边界，默认就是Object
    T value;

    private static void show(){
        Class<?> clazz = TestTypeVariableBean.class;

        //获得泛型类上的参数
        Type[]  types = clazz.getTypeParameters();


        for (Type type:types){
            TypeVariable typeVariable = (TypeVariable) type;
            int index = typeVariable.getBounds().length - 1;

            //输出上边界
            System.out.println("--getBounds()-- " + typeVariable.getBounds()[index]);

            //输出名称
            System.out.println("--getName()--" + typeVariable.getName());
            //输出所在的类的类型
            System.out.println("--getGenericDeclaration()--" +  typeVariable.getGenericDeclaration());
        }
    }
    public static void main(String[] args) {


    }

}
