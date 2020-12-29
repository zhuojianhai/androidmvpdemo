package com.example.myaidl.base;

/**
 * 所有base接口的父类
 * CONTRACT 为契约接口
 * @param <CONTRACT>
 */
public abstract class SuperBase<CONTRACT> {
    public abstract CONTRACT getContract();
}
