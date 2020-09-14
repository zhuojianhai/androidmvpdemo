package com.zjh.javademo.proxys;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;

import sun.misc.ProxyGenerator;

//import sun.misc.ProxyGenerator;

public class TestProxyDemo {
    public static void main(String[] args) throws IOException {
        MoneyService  target = new MoneyServiceImpA();

        MoneyInvocationHandler handler = new MoneyInvocationHandler(target);

        MoneyService  proxy = (MoneyService) handler.getProxyInstance(target);

         BigDecimal money =  proxy.makeMoney();

        System.out.println(money.doubleValue());

        proxy.offerMoney();

        /***
         * 得到代理类$proxy11的字节码
         */
//        byte[] bytes =   ProxyGenerator.generateProxyClass("$proxy11",target.getClass().getInterfaces());
//
//        try {
//            //将代理类的字节码写到 根目录下，文件名字叫 $proxy11.class
//            OutputStream outputStream = new FileOutputStream("./$proxy11.class");
//            outputStream.write(bytes);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


        byte[] bytes = ProxyGenerator.generateProxyClass("$proxyself",target.getClass().getInterfaces());
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream("./proxyself.class");
            outputStream.write(bytes);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            outputStream.close();
        }
    }
}
