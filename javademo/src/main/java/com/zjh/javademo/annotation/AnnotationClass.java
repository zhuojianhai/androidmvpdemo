package com.zjh.javademo.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class AnnotationClass {
    public void showInfo(
            @MyParameterAnnotation(value = "userName") String name,
            @MyParameterAnnotation(value = "userAddress")
                    @MyParameterAnnotationB(params = "default address") String address){

    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        AnnotationClass obj = new AnnotationClass();
        obj.showInfo("麓山国际零售价格","kslklsjglsgjlgjg ");

        Method[] methods = obj.getClass().getDeclaredMethods();
        for (Method method:methods){
            System.out.println(method.getName());
            //获得方法参数的所有注解
         Annotation[][] annotations =  method.getParameterAnnotations();
         for (int i=0;i<annotations.length;i++){
             Annotation[] annotations1 = annotations[i];
             for (int j=0;j<annotations1.length;j++){

                 Annotation a = annotations1[j];
                 sb.append(a+"\n");
                 if(a!=null){
                   if(a.annotationType().isInstance(MyParameterAnnotation.class)) {
                       MyParameterAnnotation mya = (MyParameterAnnotation) a;
                    sb.append("MyParameterAnnotation "+((MyParameterAnnotation) a).value()+"\n");
                   }else {
                       //sb.append("MyParameterAnnotationB "+((MyParameterAnnotationB) a).params()+"\n");
                   }
                 }
                     System.out.println(sb.toString());
             }
         }


            System.out.println(">>>>>>>>>>>>>>>>>>>获得参数类型>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            Class<?>[] parameterTypes =  method.getParameterTypes();
            for (Class clazz:parameterTypes ) {
                System.out.println(clazz);
            }
            System.out.println("!!!!!!!!!!!!!!!!获得方法的参数泛型类型!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
           Type[] genericParameterType =  method.getGenericParameterTypes();

            for (Type t:genericParameterType) {
                System.out.println(t);

            }

        }





    }
}
