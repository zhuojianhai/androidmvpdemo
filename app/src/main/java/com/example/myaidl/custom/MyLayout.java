package com.example.myaidl.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class MyLayout extends LinearLayout {
    public MyLayout(Context context) {
        super(context);
    }

    public MyLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    {
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);

        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(100,100,100,paint);
        paint.setColor(Color.GREEN);
        canvas.drawCircle(400,400,100,paint);
        paint.setColor(Color.RED);
        canvas.drawCircle(800,800,100,paint);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    /**
     * 如果不是滑动控件，返回fasle
     * 这样可以将子控件延迟100毫秒响应的设计给取消掉
     * @return
     */
    @Override
    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
