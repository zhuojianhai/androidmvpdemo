package com.example.myapplication.base;

import androidx.annotation.LayoutRes;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public abstract class BaseActivity<P extends BasePresenter,Contract> extends AppCompatActivity {

    protected P mPresenter;
    protected abstract  Contract getContract();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutRes());
        mPresenter = getmPresenter();
        mPresenter.bindView(this);
        initData();
    }

    protected abstract P getmPresenter() ;

    @LayoutRes
    protected abstract int getLayoutRes();

    protected abstract  void  initData();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        destory();
    }

    protected abstract void destory();
}