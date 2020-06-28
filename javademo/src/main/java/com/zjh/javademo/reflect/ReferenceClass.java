package com.zjh.javademo.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

public class ReferenceClass {
    private int age;
    private String name;
    private String address;
    private Map<String,String> hashMap;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Map<String, String> getHashMap() {
        return hashMap;
    }

    public void setHashMap(Map<String, String> hashMap) {
        this.hashMap = hashMap;
    }

    @Override
    public String toString() {
        return "ReferenceClass{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", hashMap=" + hashMap +
                '}';
    }


    public static void main(String[] args) {
        try {
            ReferenceClass instance = ReferenceClass.class.newInstance();

        Field fields[] = ReferenceClass.class.getDeclaredFields();
        for (Field f:fields){
            f.setAccessible(true);
            Type type = f.getGenericType();
            if (type instanceof ParameterizedType){
                System.out.println(type);
            }else{
                System.out.println("####f.getName()####" +f.getName());;
                //获得属性的类型
               String fieldTypeString =  f.getType().getSimpleName();
               if(fieldTypeString.equals("int")){
                   f.set(instance,100);
               }else if(fieldTypeString.equals("String")){
                   f.set(instance,"zhuojianhai");
               }

            }
        }

            System.out.println("=================");
        for (Field f:fields){
            f.setAccessible(true);
            System.out.println(f.get(instance));;
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
