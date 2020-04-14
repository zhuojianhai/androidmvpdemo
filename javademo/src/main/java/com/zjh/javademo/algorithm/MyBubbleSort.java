package com.zjh.javademo.algorithm;

import java.util.ArrayList;
import java.util.List;

public class MyBubbleSort {

    public static void myBubbleSort(int array[]){
        int length = array.length;
        for(int i=0;i<length-1;i++){

            boolean changed = true;
            for(int j=0;j<length-1-i;j++){
                int temp;

                if(array[j]>array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
                changed = false;

            }

            if(changed){
                break;
            }
        }



        for (int i=0;i<length;i++){
            System.out.println(array[i]);
        }
    }

    public static void myQuickSortOne(int array[]){
        int length = array.length;
        for(int i=0;i<length-1;i++){

            for(int j=0;j<length-1-i;j++){
                int temp;
                if(array[j]>array[j+1])
                {
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }


        }
    }



    public static void main(String[] args) {
       int array[] = new int[]{10,2,4,39,2,55,100,32,88};
        myBubbleSort(array);

    }
}
