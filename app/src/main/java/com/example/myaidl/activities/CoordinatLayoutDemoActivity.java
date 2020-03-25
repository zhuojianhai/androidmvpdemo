package com.example.myaidl.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.myaidl.R;

public class CoordinatLayoutDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view  = getWindow().getDecorView();

        setContentView(R.layout.activity_coordinat_layout_demo);
    }
}
