package com.example.myaidl.base;

public abstract  class BasePresenter<V extends BaseActivity,M extends BaseModel,CONTRACT> extends SuperBase<CONTRACT>{
    public V mView;
    public M mModel;

    public BasePresenter(V mView){
        this.mView = mView;
        mModel = getmModelInstance();
    }

    public BasePresenter(){
        mModel = getmModelInstance();
    }

    protected abstract M getmModelInstance();

    public void bindView(V mView){
        this.mView = mView;
    }

    public void unBindView(){
        this.mView = null;
    }
}
