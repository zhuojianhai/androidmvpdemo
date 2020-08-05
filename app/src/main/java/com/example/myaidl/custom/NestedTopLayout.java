package com.example.myaidl.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.ViewCompat;

public class NestedTopLayout extends FrameLayout implements NestedScrollingParent2 {
    private boolean mShowTop = false;
    private boolean mHideTop = false;
    private int mTopViewHeight = 800;
    private int mDefaultMarginTop = 800;


    public NestedTopLayout(@NonNull Context context) {
        super(context);
    }

    public NestedTopLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        scrollBy(0,-mDefaultMarginTop);
    }

    @Override
    public boolean onStartNestedScroll(@NonNull View child, @NonNull View target, int axes, int type) {
        return (axes & ViewCompat.SCROLL_AXIS_VERTICAL)!=0;
    }

    @Override
    public void onNestedScrollAccepted(@NonNull View child, @NonNull View target, int axes, int type) {

    }

    @Override
    public void onStopNestedScroll(@NonNull View target, int type) {

    }

    @Override
    public void onNestedScroll(@NonNull View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {

    }

    @Override
    public void onNestedPreScroll(@NonNull View target, int dx, int dy, @NonNull int[] consumed, int type) {

        int mdy = dy;
//        mShowTop = dy<0 && Math.abs(scrollY) <= mTopViewHeight && !target.canScrollVertically(-1);
//
//        if(mShowTop){
//
//        }
    }
}
