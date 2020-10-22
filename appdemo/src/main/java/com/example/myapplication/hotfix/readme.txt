如何将.java 文件转换成 .dex 文件

1、将xx.java文件转成xx.class 文件  使用如下命令
    D:\projects\selfandroid-projects\Aidlprojects\appdemo\src\main\java\com\example\myapplication\hotfix>javac Title.java
    会在当前目录下生产 Title.class 文件

2、将xx.class 转换成 xx.dex 文件 使用如下命令
    D:\projects\selfandroid-projects\Aidlprojects\appdemo\src\main\java\com\example\myapplication\hotfix>d8 Title.class
    会在当前目录下生产 Title.dex文件




