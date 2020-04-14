package com.zjh.javademo.proxys;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MoneyInvocationHandler implements InvocationHandler {
    //目标对象
    private Object target;
    public MoneyInvocationHandler(){

    }
    public MoneyInvocationHandler(Object target){
        this.target = target;

    }

    public Object getProxyInstance(Object target){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }
    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {

        String methodName = method.getName();
        System.out.println("before  invoke method "+method.getName());

        if(methodName.equals("offerMoney")){
            System.out.println("you  can't invoke the method ");
            return null;
        }
        Object result = method.invoke(target,objects);
        System.out.println("after  invoke method "+method.getName());
        return result;
    }
}
