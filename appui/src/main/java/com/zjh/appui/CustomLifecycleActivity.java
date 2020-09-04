package com.zjh.appui;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;

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


    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        return mLifecycleRegistry;
    }
}
