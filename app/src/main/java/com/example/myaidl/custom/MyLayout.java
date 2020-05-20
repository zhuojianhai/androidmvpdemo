package com.example.myaidl.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
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
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(getWidth()/2,getHeight()/2,300,paint);
        canvas.drawColor(Color.parseColor("#88880000");


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
}
