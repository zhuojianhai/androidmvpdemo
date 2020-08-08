package com.zjh.javademo.reflect.types;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

@CustomAnnotation(name = "sampleClass",value = "sample class Annotation")
public class SampleClass {
    private String  sampleFieldId;

    public String getSampleFieldId() {
        return sampleFieldId;
    }

    @CustomAnnotation(name = "method-setSampleFieldId",value = "set sample mehtod value")
    public void setSampleFieldId(
                                @CustomAnnotation(name = "sampleMethod", value = "sampleMethod annotation")
                                 String sampleFieldId,

                                 String name,

                                 @CustomAnnotation(name = "ageMethod",value = "age annotation")
                                 @ParamsFields(pName = "agePname",pValue = "agePvalue")
                                 String age) {
        this.sampleFieldId = sampleFieldId;
    }

    private static void showInfo(){
        try {
            Class clazz = SampleClass.class;
            Method setSampleFieldIdMethod = clazz.getDeclaredMethod("setSampleFieldId",String.class,String.class,String.class);
            Class<?>[] c = setSampleFieldIdMethod.getParameterTypes();

            Type[] types = setSampleFieldIdMethod.getGenericParameterTypes();


            //获得方法参数的泛型
            Annotation[][] annotations = setSampleFieldIdMethod.getParameterAnnotations();

            //获得方法上面的注解
           Annotation[] methodAnnotions =  setSampleFieldIdMethod.getAnnotations();

           for (Annotation mA:methodAnnotions){
             if(mA instanceof CustomAnnotation){
                 System.out.println(((CustomAnnotation) mA).name() +"   "+((CustomAnnotation) mA).value());
             }

           }


        }catch (Exception e){
            e.printStackTrace();
        }




    }
    public static void main(String[] args) {
        showInfo();

    }

    private static void s(){
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
