package com.example.myapplication.generic;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

@CustomAnnotation(name = "sampleclass", value="sample class annotation ")
public class SampleClass {
    private String  sampleFieldId;

    public String getSampleFieldId() {
        return sampleFieldId;
    }

    public void setSampleFieldId(
            @CustomAnnotation(name = "sampleMethod", value = "sampleMethod annotation")
                    String sampleFieldId,

            String name,

            @CustomAnnotation(name = "ageMethod",value = "age annotation")
            @ParamsFields(pName = "agePname",pValue = "agePvalue")
                    String age) {
        this.sampleFieldId = sampleFieldId;
    }

    public static void main(String[] args) {
        Method[] method = SampleClass.class.getDeclaredMethods();

        for (Method m: method) {
            Class<?>[] parameterTypes = m.getParameterTypes();
            for(Class<?> type:parameterTypes){
                System.out.println("获取方法所有参数类型"+type);
                //获取方法所有参数类型class java.lang.String
                //获取方法所有参数类型int
            }
            System.out.println("----------------------");

            //getGenericParameterTypes():获取泛型参数类型
            Type[] genericParameterTypes = m.getGenericParameterTypes();
            for(Type t: genericParameterTypes){
                System.out.println(t);
                //class java.lang.String
                //int
            }

            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>");
            //getParameterAnnotations():获取方法参数所有注解
            Annotation[][] pas = m.getParameterAnnotations();
            for(Annotation[] p:pas){
                for(Annotation s:p){
                    System.out.println(s);
                    //@retrofit2.demo.CustomAnnotation(name=sampleMethod, value=sampleMethod annotation)
                }
            }

        }
    }
}
