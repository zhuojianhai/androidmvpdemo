package com.example.myapplication.base;
/**
 * 
 * @author zhuojianhai
 * time 2020/12/29 11:29
 * 维护者 
 */
public abstract class BaseModel<P extends BasePresenter,Contract> implements SuperBase<Contract>{
    protected  P mPresenter;
    public BaseModel(P mPresenter){
        this.mPresenter = mPresenter;
    }



}