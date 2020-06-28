package com.zjh.javademo.proxys.demo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class UserRequest {
    public static void main(String[] args) {
        IRequest iRequest = new RequestImpl();
        IRequestInvocationHandler iRequestInvocationHandler = new IRequestInvocationHandler();
        IRequest proxyObject = (IRequest) iRequestInvocationHandler.getProxyInstance(iRequest);
        proxyObject.request("say hello to the world");

    }
}