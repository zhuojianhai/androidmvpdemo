package com.example.myaidl.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class BookView extends View {

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    public BookView(Context context) {
        super(context);
    }

    public BookView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    {
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(32);
    }


    int startAngle = 120;
    int swipAngle = 300;
    int progressAngle = 0;
    Paint.FontMetrics fontMetrics = new Paint.FontMetrics();


    String text = "旋转角度270";
    public int getProgressAngle() {
        return progressAngle;
    }

    public void setProgressAngle(int progressAngle) {
        this.progressAngle = progressAngle;
        invalidate();
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //设置背景色
        canvas.drawARGB(255, 139, 197, 186);

        RectF bound = new RectF(100,100,getWidth()/2,getWidth()/2);

        canvas.save();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.GRAY);
       // canvas.drawArc(100,100,getWidth()/2,getWidth()/2,startAngle,swipAngle,false,paint);
        canvas.drawArc(bound,startAngle,swipAngle,false,paint);

        paint.setColor(Color.RED);
        canvas.drawArc(bound,startAngle,progressAngle,false,paint);


        paint.setColor(Color.GREEN);
//        canvas.drawText(text,bound.left + bound.centerX(),bound.top+bound.centerY()-(fontMetrics.ascent+fontMetrics.descent)/2,paint);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(40);
        paint.setTextAlign(Paint.Align.CENTER);

        int offset = (int )(fontMetrics.ascent+fontMetrics.descent)/2;// 设置将文本居中显示
        canvas.drawText(text, bound.centerX(),bound.centerY()-offset,paint);
        canvas.restore();

    }
}
