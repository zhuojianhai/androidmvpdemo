package com.zjh.javademo.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 通过反射获取到泛型信息
 */
public class ReflectInfo {

    public <T> Map<String,String> testMethod(Map<String,String> map, List<String> list){
        System.out.println("this is testMethod");
        return new HashMap<>();
    }

    public Map<String,String> testMethod2(){
        System.out.println("this is testMethod2");

        return new HashMap<>();
    }
    public static void main(String[] args) {

        Class clazz = ReflectInfo.class;
        try {
            Method testMethod = clazz.getDeclaredMethod("testMethod", Map.class, List.class);

            //参数上对应的注解
            Annotation[][]  parameterAnnotaions = testMethod.getParameterAnnotations();

            //获得方法参数的泛型信息
            Type[] types = testMethod.getGenericParameterTypes();
            for (Type t: types) {
                System.out.println("#"+t);
                if(t instanceof ParameterizedType){
                    Type[] genericTypes = ((ParameterizedType) t).getActualTypeArguments();
                    for (Type par: genericTypes) {
                        System.out.println("泛型类型#"+par);
                    }
                    System.out.println();
                }

            }

          int count =   testMethod.getParameterCount();
            System.out.println("parameter count is =="+count);

            //获得方法返回值类型
           Type returenType = testMethod.getGenericReturnType();
            System.out.println(returenType);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }
}
