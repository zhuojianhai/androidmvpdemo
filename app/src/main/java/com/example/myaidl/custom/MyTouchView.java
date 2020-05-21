package com.example.myaidl.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class MyTouchView extends View {
    public MyTouchView(Context context) {
        super(context);
    }

    public MyTouchView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getActionMasked() == MotionEvent.ACTION_UP){
            performClick();
        }

        if(event.getActionMasked() == MotionEvent.ACTION_DOWN){
            return true;
        }else{
            return false;
        }
    }
}
