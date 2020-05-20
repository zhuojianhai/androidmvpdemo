package com.example.myaidl.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.os.Bundle;

import com.example.myaidl.R;
import com.example.myaidl.custom.BookView;

public class CustomerViewActivity extends AppCompatActivity {

    BookView bookView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_view);

        bookView = findViewById(R.id.bookview);
        ObjectAnimator animator = ObjectAnimator.ofInt(bookView,"progressAngle",270);

        animator.setStartDelay(2000);
        animator.setDuration(2000);
        animator.start();
    }
}
