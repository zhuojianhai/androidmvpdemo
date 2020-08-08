package com.zjh.javademo.retrofits;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class ServiceMethod<R,T> {

    public ServiceMethod(Builder<T,R> builder){

    }

    static final class Builder<T,R>{
        final Retrofit retrofit;
        final Method method;

        final Annotation[] methodAnnotations;//方法上的注解
        final Annotation[][] parameterAnnotationsArray;//方法参数上注解
        final Type[] parameterTypes;//方法参数的类型

        Builder(Retrofit retrofit, Method method){
            this.retrofit = retrofit;
            this.method = method;
            this.methodAnnotations = method.getAnnotations();
            this.parameterAnnotationsArray = method.getParameterAnnotations();
            this.parameterTypes = method.getGenericParameterTypes();
        }


        public ServiceMethod build(){
            return new ServiceMethod(this);
        }

    }
}
