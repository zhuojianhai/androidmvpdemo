package com.zjh.javademo.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.TypeVariable;
import java.util.List;

public class TestGenericArrayTypeBean<T> {
    //泛型数组类型
    private T[] value;
    private List<String>[] list;

    //不是泛型数组类型
    private List<String> singleList;
    private T singleValue;


    private static void method1(){
        Field[] fields = TestGenericArrayTypeBean.class.getDeclaredFields();

        for (Field field:fields) {
            field.setAccessible(true);
            //输出当前变量是否为GenericArrayType类型
            System.out.println("Field: " + field.getName() + "; instanceof GenericArrayType" + ": " + (field.getGenericType() instanceof GenericArrayType));
            if (field.getGenericType() instanceof GenericArrayType){
                //如果是GenericArrayType，则输出当前泛型类型
                System.out.println("Field: "
                        + field.getName()
                        + "; getGenericComponentType()"
                        + ": "
                        + (((GenericArrayType) field.getGenericType()).getGenericComponentType()));
            }
        }
    }
    public static void main(String[] args) {

        try {
            Field field = TestGenericArrayTypeBean.class.getDeclaredField("singleValue");
            if (field.getGenericType() instanceof TypeVariable){
                System.out.println(field.getGenericType().getTypeName());
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }


    }

}
