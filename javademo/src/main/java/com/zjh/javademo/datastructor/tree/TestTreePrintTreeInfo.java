package com.zjh.javademo.datastructor.tree;

import com.zjh.javademo.datastructor.tree.bean.Student;
import com.zjh.javademo.datastructor.tree.printer.BinaryTrees;

import java.util.Comparator;
import java.util.Random;


public class TestTreePrintTreeInfo {
    public static void main(String[] args) {

        Integer integer[] = new Integer[]{
               7,4,9,2,5,8,11,1,3,10,12
        };
        BinarySearchTreePrinter<Integer> bs = new BinarySearchTreePrinter<>();
        for (int i=0;i<integer.length;i++){
            bs.add(integer[i]);
        }

        BinaryTrees.print(bs);

        System.out.println();

        BinarySearchTreeVistor<Integer> bss = new BinarySearchTreeVistor<>();
        for (int i=0;i<integer.length;i++){
            bss.add(integer[i]);
        }

        bss.preorderTraversal();

        bss.levelOrderTraversal();

    }
}
