package com.zjh.javademo.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.HashMap;

public class TestReflect {
    public static void main(String[] args) {
        showClassInfo();
    }

    private static void showClassInfo(){
        try {
            Class<ReflectClassDemo> clazz = (Class<ReflectClassDemo>) Class.forName("com.zjh.javademo.reflect.ReflectClassDemo");

//            ReflectClassDemo RCInstance =  clazz.newInstance();
           Constructor constructor =  clazz.getDeclaredConstructor(null);
            ReflectClassDemo RCInstance = (ReflectClassDemo) constructor.newInstance(null);

            Field fields[] = clazz.getDeclaredFields();

            for (Field f:fields) {
                f.setAccessible(true);
               String fieldTypeName =  f.getType().getCanonicalName();
                System.out.println(fieldTypeName);

                if(fieldTypeName.equals("int")){
                    f.setInt(RCInstance,100);

                }else if (fieldTypeName.equals("byte")){
                    f.setByte(RCInstance, (byte) 1);
                }else if(fieldTypeName.equals("short")){
                    f.setShort(RCInstance, (short) 3);
                }else if(fieldTypeName.equals("long")){
                    f.setLong(RCInstance,8);
                }else if (fieldTypeName.equals("float")){
                    f.setFloat(RCInstance,30f);
                }else  if (fieldTypeName.equals("double")){
                    f.setDouble(RCInstance,99d);
                }else if (fieldTypeName.equals("char")){
                    f.setChar(RCInstance,'S');
                }else if (fieldTypeName.equals("boolean")){
                    f.setBoolean(RCInstance,true);
                }

            }

            System.out.println("============================================================================");
            for (Field f:fields){
                f.setAccessible(true);
                System.out.println(f.get(RCInstance));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    private void showCInfo(){

        ReferenceClass rc = new ReferenceClass();
        rc.setName("reference name ");
        rc.setAddress("located imagic place");
        rc.setHashMap(new HashMap<String, String>());


        Class clazz = rc.getClass();


        ParameterizedType parameterizedType = null;//作用于方法上
        TypeVariable typeVariable = null;  //作用在类上

        GenericArrayType genericArrayType = null;//作用于数组

        WildcardType  wildcardType = null;//通配符类型   也是作用于方法上




    }
}
