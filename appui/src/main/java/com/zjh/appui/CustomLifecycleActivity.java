package com.zjh.appui;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.Observer;

import com.zjh.appui.databinding.MyDataBindingDemoActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CustomLifecycleActivity extends Activity implements LifecycleOwner {
    private LifecycleRegistry mLifecycleRegistry;

    @BindView(R.id.bt_login)
    Button loginBt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_lifecycle);
        ButterKnife.bind(this);

        mLifecycleRegistry = new LifecycleRegistry(this);
        mLifecycleRegistry.setCurrentState(Lifecycle.State.CREATED);

        subscribeLifecycleEvent();
    }

    private void subscribeLifecycleEvent() {
        //监听activity的生命周期
       getLifecycle().addObserver(new LifecycleEventObserver() {
           @Override
           public void onStateChanged(@NonNull LifecycleOwner source, @NonNull Lifecycle.Event event) {
               System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+event);
           }
       });

    }

    @OnClick(R.id.bt_login)
    public void login(){
        Intent intent = new Intent(this,MyRecyclerViewActivity.class);
        startActivity(intent);

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLifecycleRegistry.setCurrentState(Lifecycle.State.DESTROYED);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mLifecycleRegistry.setCurrentState(Lifecycle.State.STARTED);
    }


    @OnClick({R.id.bt_login})
    public void onClick(View view){
        int id = view.getId();
        switch (id){
            case R.id.bt_login:
                Intent intent = new Intent(this, MyDataBindingDemoActivity.class);
                startActivity(intent);
                break;
        }

    }
    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        return mLifecycleRegistry;
    }
}
