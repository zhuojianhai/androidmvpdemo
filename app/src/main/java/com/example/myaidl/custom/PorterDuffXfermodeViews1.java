package com.example.myaidl.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class PorterDuffXfermodeViews1 extends View {
    public PorterDuffXfermodeViews1(Context context) {
        super(context);
    }

    public PorterDuffXfermodeViews1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    {

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //alpha 是255 是不透明的
        canvas.drawARGB(255, 139,197,186);
        int canvasWidth = canvas.getWidth();
        int r = canvasWidth / 3;
        //绘制黄色的圆形
        paint.setColor(0xFFFFCC44);
        canvas.drawCircle(r, r, r, paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        //绘制蓝色的矩形
        paint.setColor(0xFF66AAFF);
        canvas.drawRect(r, r, r * 2.7f, r * 2.7f, paint);
        paint.setXfermode(null);




    }
}
