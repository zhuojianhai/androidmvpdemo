package com.zjh.javademo.reflect.types;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Test {
    public static void main(String[] args) {


        showParamenterInfo();

    }

    private static void show(){
        Integer integer = new Integer(1);
        System.out.println(integer.intValue());


        String value = "9D:03:15:F7:05:2D:25:F1:1F:0F:D1:88:81:AB:2F:88";
        String ss = "F2:8C:C7:EC:52:73:DF:30:A7:E8:86:33:8F:5C:32:81";
       String news =  ss.replace(":","");
        System.out.println(news);


        String phone = "公共邀请码:2121";
        System.out.println(phone.substring(6));
    }

    private static void showParamenterInfo(){
        Method[]  methods = SampleClass.class.getMethods();
        for (Method method : methods) {

            if("setSampleFieldId".equals(method.getName())){
                System.out.println(method);
                /**
                 *获得方法参数注解信息
                 * 二维数组的长度就是这个方法参数个数
                 * 二维数据，
                 * 第一维度数组存储的是这个方法参数的个数，
                 * 第二维数组存储的是注解的个数
                 *
                 */

                Annotation[][] annotations =  method.getParameterAnnotations();
                System.out.println("方法参数的个数为： "+annotations.length);
                for (Annotation[] annotation1 : annotations) {

                    System.out.println("参数上注解的个数为 "+annotation1.length);
                    System.out.println("-------------start-------------------");
                    for (Annotation annotation : annotation1) {

                        if (annotation instanceof CustomAnnotation) {
                            CustomAnnotation customAnnotation = (CustomAnnotation) annotation;
                            System.out.println("name: " + customAnnotation.name());
                            System.out.println("value: " + customAnnotation.value());
                        }
                        if(annotation instanceof ParamsFields){
                            ParamsFields pf = (ParamsFields) annotation;
                            System.out.println("pname: "+pf.pName());
                            System.out.println("pvalue: "+pf.pValue());
                        }

                    }
                    System.out.println("------------end--sl老师的交给老师--------------");
                }
            }
        }



    }
}
