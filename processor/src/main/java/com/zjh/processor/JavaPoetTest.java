package com.zjh.processor;

import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;

import javax.lang.model.element.Modifier;


public class JavaPoetTest {
    public static void main(String[] args) {
        generateFiles();
        generateOne();

    }

    private static void generateOne(){
        FieldSpec intField = FieldSpec.builder(int.class,"resultValue")
                .addModifiers(Modifier.PUBLIC,Modifier.STATIC)

                .build();
        MethodSpec computeRange = computeRange("result",1,10,"+");
        ParameterSpec mainParameter = ParameterSpec.builder(String[].class,"main").build();
        MethodSpec methodSpec = MethodSpec.methodBuilder("main")
                .addModifiers(Modifier.PUBLIC,Modifier.STATIC)
                .addParameter(mainParameter)

                .addStatement("long now = $T.currentTimeMillis()",System.class)
                .beginControlFlow("if ( $T.currentTimeMillis() < now )",System.class)
                .addStatement("$T.out.println($S)", System.class, "Time travelling, woo hoo!")
                .nextControlFlow("else if ($T.currentTimeMillis() == now)", System.class)
                .addStatement("$T.out.println($S)", System.class, "Time stood still!")
                .nextControlFlow("else")
                .addStatement("$T.out.println($S)", System.class, "Ok, time still moving forward")
                .endControlFlow()

                .addStatement("resultValue = 0")
                .addStatement("resultValue = $N()",computeRange)
                .addStatement("$T.out.println($S)",System.class,"resultValue")
                .addStatement("System.out.println(resultValue)")


                .beginControlFlow("try")
                .addStatement("throw new Exception($S)","fail")
                .nextControlFlow("catch ($T e)", Exception.class)
                .addStatement("throw new $T(e)", RuntimeException.class)
                .endControlFlow()


                .build();





        TypeSpec typeSpec = TypeSpec.classBuilder("HelloAddStatement")
                .addMethod(methodSpec)
                .addModifiers(Modifier.PUBLIC)
                .addMethod(computeRange)
                .addField(intField)
                .build();
        JavaFile javaFile = JavaFile.builder("com.zjh.processor.poet",typeSpec).build();
        //文件生成存放的位置
        File outputFile = new File("processor/src/main/java/"); //输出文件

        try {
            javaFile.writeTo(outputFile);
            javaFile.writeTo(System.out);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static MethodSpec computeRange(String name,int from ,int to,String op ){
        return MethodSpec.methodBuilder(name)
                .returns(int.class)
                .addModifiers(Modifier.PUBLIC,Modifier.STATIC)
                .addStatement("int result = 0")
                .beginControlFlow("for (int i= $L ;i<$L;i++)",from,to)
                .addStatement("result = result $L i",op)
                .endControlFlow()
                .addStatement("return result")
                .build();

    }



    private static void generateFiles(){

        ParameterSpec showParameter = ParameterSpec.builder(String.class,"name").build();

        MethodSpec methodSpec = MethodSpec.methodBuilder("show").
                addModifiers(Modifier.PUBLIC,Modifier.STATIC)
                .addParameter(showParameter)
                .addStatement("$T.out.println($S)",System.class,"Hello World!")
                .addStatement("$T.out.println($L)",System.class,showParameter.name)
                .build();


        //构造main方法的参数
        ParameterSpec parameterSpec = ParameterSpec.builder(String[].class,"args").build();


        //构造方法
        MethodSpec main = MethodSpec.methodBuilder("main").
                addModifiers(Modifier.PUBLIC,Modifier.STATIC)
                .returns(TypeName.VOID)
                .addParameter(parameterSpec)
                .addStatement("$T.out.println($S)",System.class,"Hello World!")
                .build();

        TypeSpec typeSpec = TypeSpec.classBuilder("Helloworld")
                .addModifiers(Modifier.PUBLIC)
                .addMethod(methodSpec)
                .addMethod(main)
                .build();

        JavaFile javaFile = JavaFile.builder("com.zjh.processor.poet",typeSpec)
                .build();

        //文件生成存放的位置
        File outputFile = new File("processor/src/main/java/"); //输出文件

        try {
            javaFile.writeTo(outputFile);
            javaFile.writeTo(System.out);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
