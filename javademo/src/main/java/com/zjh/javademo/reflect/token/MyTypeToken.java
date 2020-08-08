package com.zjh.javademo.reflect.token;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract  class MyTypeToken<T> {
    private final Type type;
    public MyTypeToken(){
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass instanceof  Class){
            throw new  RuntimeException("Miss type parameter");
        }

        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        Type[] typeArgus = parameterizedType.getActualTypeArguments();
        type = typeArgus[0];
    }

    public Type getType(){
        return  type;
    }
}
