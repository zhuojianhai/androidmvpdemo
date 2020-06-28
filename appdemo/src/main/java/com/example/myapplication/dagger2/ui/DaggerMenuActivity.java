package com.example.myapplication.dagger2.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myapplication.R;
import com.example.myapplication.dagger2.di.DaggerCookComponent;
import com.example.myapplication.dagger2.impl.Chef;

import javax.inject.Inject;

public class DaggerMenuActivity extends AppCompatActivity {

    @Inject
    Chef chef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger_menu);

        DaggerCookComponent.builder().build();

        System.out.println("DaggerMenuActivity"+chef.cook());

    }
}
