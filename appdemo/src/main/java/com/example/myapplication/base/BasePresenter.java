package com.example.myapplication.base;
/**
 * 
 * @author zhuojianhai
 * time 2020/12/29 11:29
 * 维护者 
 */

public abstract class BasePresenter<V extends BaseActivity,M extends BaseModel,Contract> implements SuperBase<Contract>{
    public V mView;
    public M mModel;

    public BasePresenter(){
        this.mModel = getModelInstance();
    }

    protected abstract M getModelInstance();

    public void bindView(V mView){
        this.mView = mView;
    }

    public void unbindView(){
        this.mView = null;
    }
}