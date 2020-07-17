package com.zjh.javademo.proxys.demo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class IRequestInvocationHandler implements InvocationHandler {
    private Object target;//代理对象

    public IRequestInvocationHandler(){
        super();
    }

    public IRequestInvocationHandler(Object target){
        this.target = target;
    }

    /**
     * 获得 target对象的代理对象
     * @param target
     * @return  Object
     */
    public Object  getProxyInstance(Object target){
        if (this.target == null){
            this.target = target;
        }
       return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    public Object getProxyInstancebyClass(Class target){
        try {
            this.target = target.newInstance();
            return Proxy.newProxyInstance(target.getClassLoader(),target.getInterfaces(),this);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return  null;
    }
    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println("begain invoke method "+method);
      Object result =   method.invoke(target,objects);

        System.out.println("invok result is "+result.toString());
        System.out.println("end invoke method"+method);
        return result;
    }
}
