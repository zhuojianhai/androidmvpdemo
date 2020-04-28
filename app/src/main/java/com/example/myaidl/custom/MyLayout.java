package com.example.myaidl.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;

public class MyLayout extends ViewGroup {
    public MyLayout(Context context) {
        super(context);
    }

    public MyLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }
}
