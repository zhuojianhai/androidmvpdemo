package com.example.myaidl.base;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public abstract  class BaseFragment<P extends BaseFragmentPresenter,CONTRACT> extends Fragment implements View.OnClickListener{

    public abstract CONTRACT getContract();
    public P mPresenter;
    public abstract P getmPresenterInstance();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getContentViewId(),container,false);

        initViews();
        initListener();
        initData();

        mPresenter = getmPresenterInstance();
        mPresenter.bindView(this);
        return view;
    }

    protected abstract void initData();


    public abstract  void initViews();
    public abstract  void initListener();
    public abstract  int getContentViewId();

    public abstract <ERROR extends Object> void responseError(ERROR error,Throwable throwable);

    @Override
    public void onDestroy() {
        super.onDestroy();
        onDestory();
    }
    public abstract  void onDestory();

    @Override
    public void onClick(View v) {

    }
}
