package com.zjh.javademo.datastructor.tree;

import com.zjh.javademo.datastructor.tree.bean.Student;
import com.zjh.javademo.datastructor.tree.printer.BinaryTrees;

import java.util.Comparator;
import java.util.Random;


public class TestTreePrintTreeInfo {
    public static void main(String[] args) {

        Integer integer[] = new Integer[]{
                1,20,5,12,25,8,7
        };
        BinarySearchTreePrinter<Integer> bs = new BinarySearchTreePrinter<>();
        for (int i=0;i<integer.length;i++){
            bs.add(integer[i]);
        }

        BinaryTrees.print(bs);

    }
}
