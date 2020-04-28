package com.zjh.javademo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class MyClass {

    public static void main(String[] args) {
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
