package com.zjh.appui.databinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import android.os.Bundle;

import com.zjh.appui.R;
import com.zjh.appui.beans.GoodsBean;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class MyDataBindingDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_data_binding_demo);

      ActivityDataBindingDemoBinding dataBindingDemoBinding =   DataBindingUtil.setContentView(this,R.layout.activity_data_binding_demo);
        GoodsBean goodsBean = new GoodsBean();
        goodsBean.setName("上好佳");
        goodsBean.setPrice("1389.89");
        dataBindingDemoBinding.setGood(goodsBean);

        LiveData liveData;
        MutableLiveData<String> data = new MutableLiveData<>();

        CompositeDisposable compositeDisposable = new CompositeDisposable();
        compositeDisposable.add(new Disposable() {
            @Override
            public void dispose() {

            }

            @Override
            public boolean isDisposed() {
                return false;
            }
        });
    }
}
