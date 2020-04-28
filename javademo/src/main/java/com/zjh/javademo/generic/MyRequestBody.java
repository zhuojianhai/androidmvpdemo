package com.zjh.javademo.generic;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyRequestBody<T> {

    public MyRequestBody(){

    }


    public  <T> T getInstance( Class<T> clazz){

       boolean flag =  clazz.isInstance(Fruit.class);
        System.out.println(clazz.getClass().getCanonicalName()+"  is Fruit instance "+ flag);
        try {
            return clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }


    public void showInfo(String name,String arg,int age){

    }

    public <T> T showInfo(Class<T> name, List<T> container){
        return null;
    }

    public static void main(String[] args) {
        MyRequestBody<Fruit> requestBody = new MyRequestBody();
//        Fruit fruit =   requestBody.getInstance(Fruit.class);
//        System.out.println(fruit.toString());


        Method[] methods = requestBody.getClass().getDeclaredMethods();
        for (Method method:methods) {
            System.out.println(method.getName());

            showParameterTypesInfo(method);

            System.out.println("-------------end-------------");

            System.out.println();
            showGenericParamterTypeInfo(method);


        }

    }


    /**
     * 获取方法所有参数类型
     * @param method
     */
    private static void showParameterTypesInfo(Method method){

        Class<?>[] paramsTypes = method.getParameterTypes();
        for (int i = 0; i < paramsTypes.length; i++) {
            System.out.println(paramsTypes[i]);
        }

    }

    /**
     * 获取泛型参数类型
     * @param method
     */
    private static void showGenericParamterTypeInfo(Method method){
      Type[] genericParameterTypes  =  method.getGenericParameterTypes();
        for (Type gT:genericParameterTypes) {
            System.out.println(gT);

        }

    }

}
