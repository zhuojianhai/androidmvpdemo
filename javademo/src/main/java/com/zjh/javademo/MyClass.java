package com.zjh.javademo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MyClass {

    public static void main(String[] args) {
//        random();

        System.out.println("2<<35   "+(2<<35));

        System.out.println(-35%32);
        System.out.println(35/32);
    }
    private static void random(){
        Random random = new Random();
        int staus = random.nextInt(3);
        System.out.println("status "+staus);

    }
    private static void ss(){
        LinkedList<String> data = new LinkedList<>();
        data.add("data");

        Collection<String> collection = new ArrayList<>();



        Map<String,String> hashMap = new HashMap<>();
        hashMap.put("1","name");
        hashMap.put("2","demo");

        show();


        int age = 384;
        System.out.println(age/100);
        System.out.println(age %100/10);
        System.out.println(age %100%10);


        TypeToken token = new TypeToken<List<String>>(){

        };

    }

    private static  void show(){
        for(int i=1;i<=9;i++){
            for (int j=1;j<=9;j++){
                System.out.print(i +"*" +j +" = " +i*j);
                System.out.print("    ");
                if(i == j){
                    System.out.println();
                    break;
                }
            }
            System.out.println();
        }
    }
}
