package com.zjh.mvvmdemo.base.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.zjh.mvvmdemo.R;
import com.zjh.mvvmdemo.base.viewmodel.BaseViewModel;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class BaseMvvmActivity<VDB extends ViewDataBinding,VM extends BaseViewModel> extends AppCompatActivity {

    protected  VDB binding;
    protected  VM mViewModel;
    //获取当前activity布局文件,并初始化我们的binding
    protected abstract int getContentViewId();

    //处理逻辑业务
    protected abstract void processLogic();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        binding = DataBindingUtil.setContentView(this,getContentViewId());
        binding.setLifecycleOwner(this);
        createViewModel();
        processLogic();
    }

    public void createViewModel() {
        if (mViewModel == null) {
            Class modelClass;
            Type type = getClass().getGenericSuperclass();
            if (type instanceof ParameterizedType) {
                modelClass = (Class) ((ParameterizedType) type).getActualTypeArguments()[0];
            } else {
                //如果没有指定泛型参数，则默认使用BaseViewModel
                modelClass = BaseViewModel.class;
            }
            mViewModel = (VM) ViewModelProviders.of(this).get(modelClass);
        }
    }

}
