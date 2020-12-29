package com.example.myaidl.base;


/**
 * M 要把数据回传给P层，所以持有p层
 * 在presenter的构造方法中创建Model
 * @param <P>
 */
public abstract  class BaseModel<P extends  BasePresenter,CONTRACT> extends SuperBase<CONTRACT>{
    public P mPresenter;

    public BaseModel(P mPresenter){
        this.mPresenter = mPresenter;
    }



}
