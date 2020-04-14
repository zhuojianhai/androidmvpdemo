package com.zjh.javademo.base;

public class NewPermission {
    public static   final  int ALLOW_SELECT = 1<<0;  //0001
    public static   final  int ALLOW_INSERT = 1<<1;  //0010
    public static   final  int ALLOW_UPDATE = 1<<2;  //0100
    public static   final  int ALLOW_DELETE = 1<<3;   //1000

    private int flag;// 存储目前的权限状态



}
