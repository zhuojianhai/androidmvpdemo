package com.example.myaidl.base;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.trello.rxlifecycle.components.support.RxAppCompatActivity;



public abstract class BaseActivity<P extends BasePresenter,CONTRACT> extends RxAppCompatActivity implements View.OnClickListener{
    public Activity mActivity;
    public P mPresenter;

    public abstract  CONTRACT getContract();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = getmPresenterInstatnce();
        mPresenter.bindView(this);
        setContentView(getContentViewId());

        initData();
        initView();
        initEvent();

    }
    protected abstract void initData();
    protected abstract void initView();
    protected abstract void initEvent();


    @Override
    public void setContentView(View view) {
        super.setContentView(view);
      //  ButterKnife.bind(this);
        mActivity = this;
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
       // ButterKnife.bind(this);
        mActivity = this;
    }

    protected abstract P getmPresenterInstatnce();

    protected abstract int getContentViewId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mPresenter!=null){
            mPresenter.unBindView();
        }
        destory();
    }

    protected abstract void destory();
}
