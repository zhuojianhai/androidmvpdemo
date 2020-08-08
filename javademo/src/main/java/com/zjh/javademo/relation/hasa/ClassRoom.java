package com.zjh.javademo.relation.hasa;

import java.util.ArrayList;
import java.util.List;

public class ClassRoom {
    private String classroomName;

    List<Student> studentList = new ArrayList<>();

    public void fillClassRoom(Student student){
        if (student!=null){
            studentList.add(student);
        }
    }


    public void  showStudentInfo(Student student){
        System.out.println(student.toString());
    }


}
