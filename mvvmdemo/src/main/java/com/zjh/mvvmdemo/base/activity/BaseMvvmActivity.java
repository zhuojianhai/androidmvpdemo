package com.zjh.mvvmdemo.base.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.zjh.mvvmdemo.R;

public class BaseMvvmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_mvvm);
    }
}
