package com.zjh.javademo.datastructor.tree;

import com.zjh.javademo.datastructor.tree.bean.Student;
import com.zjh.javademo.datastructor.tree.printer.BinaryTrees;

import java.util.Comparator;
import java.util.Random;


public class TestTreePrintTreeInfo {
    public static void main(String[] args) {





        preorderTraversal();
    }

    private static void showPreorder(){
        Integer integer[] = new Integer[]{
                7,4,9,2,5,8,11,1,3,10,12
        };

        System.out.println();

        BinarySearchTreeVistor<Integer> bss = new BinarySearchTreeVistor<>();
        for (int i=0;i<integer.length;i++){
            bss.add(integer[i]);
        }

        bss.preorderTraversal();

        bss.levelOrderTraversal();

        BinaryTrees.println(bss);
        System.out.println(">>>>>>>>>>>");
        bss.revertTree();

        BinaryTrees.println(bss);
    }

    private static void showTree(){
        Integer integer[] = new Integer[]{
                7,4,9,2,5,8,11,1,3,10,12
        };
        BinarySearchTreePrinter<Integer> bs = new BinarySearchTreePrinter<>();
        for (int i=0;i<integer.length;i++){
            bs.add(integer[i]);
        }

        BinaryTrees.print(bs);

    }
    private static void preorderTraversal(){
        Integer integer[] = new Integer[]{
                7,4,9,2,5,8,11,1,3,10,12
        };

        BinarySearchTreeVistorNew<Integer> tree = new BinarySearchTreeVistorNew<>();
        for (int i=0;i<integer.length;i++){
            tree.add(integer[i]);
        }

         BinaryTrees.println(tree);
        tree.preorderTraversal();
    }
}
