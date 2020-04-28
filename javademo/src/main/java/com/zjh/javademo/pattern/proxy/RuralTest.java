package com.zjh.javademo.pattern.proxy;

import java.io.FileOutputStream;
import java.io.OutputStream;

import sun.misc.ProxyGenerator;

public class RuralTest {
    public static void main(String[] args) {

        RuralInterface target = new RuralInterfaceImp();

        RuralInvacationHandler  handler = new RuralInvacationHandler();
        RuralInterface proxy= (RuralInterface) handler.getProxyInstance(target);

        proxy.showRuralName();



        /***
         * 得到代理类$proxyInterface的字节码
         */
        byte[] bytes =   ProxyGenerator.generateProxyClass("$proxyInterface",target.getClass().getInterfaces());

        try {
            //将代理类的字节码写到 根目录下，文件名字叫 $proxy11.class
            OutputStream outputStream = new FileOutputStream("./$proxy11.class");
            outputStream.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
