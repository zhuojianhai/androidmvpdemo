package com.zjh.javademo.datastructor.tree;

import com.zjh.javademo.datastructor.tree.bean.Student;

import java.util.Comparator;
import java.util.Random;


public class TestTree {
    public static void main(String[] args) {

        Integer integer[] = new Integer[]{
                1,20,5,12,25,8,7
        };
        BinarySearchTree<Integer> bs = new BinarySearchTree<>();
        for (int i=0;i<integer.length;i++){
            bs.add(integer[i]);
        }

        BinarySearchTree<Student> binarySearchTree = new BinarySearchTree<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge() - o2.getAge();
            }
        });

        Random random = new Random();
        for (int i=0;i<10;i++){
            Student student = new Student();
            int r = random.nextInt(10);
            student.setAge(r);
            student.setName("name "+r);
            binarySearchTree.add(student);

        }

        BinarySearchTree.Node<Student> root = binarySearchTree.getRoot();
        System.out.println(root.toString());

    }
}
