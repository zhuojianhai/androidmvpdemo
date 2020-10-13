package com.example.myphoneapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;

import androidx.annotation.Nullable;

public class MyView extends View {

    private static final String TAG = "MyView";
    Scroller scroller;

    Paint mPaint;
    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        scroller = new Scroller(context);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.RED);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int action = event.getAction();
        switch (action){
            case MotionEvent.ACTION_DOWN:

                break;
        }

        return super.onTouchEvent(event);

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();
        canvas.translate(100,100);
        canvas.drawCircle(0,0,40.0f,mPaint);
        canvas.drawCircle(50,50,40.0f,mPaint);
        canvas.restore();

    }

    public void startScrollBy(int dx,int dy){
        scroller.forceFinished(true);
        int startX = getScrollX();//得到滑动的水平方向起始位置
        int startY = getScrollY();//得到滑动的垂直方向起始位置
        scroller.startScroll(startX,startY,startX+dx,startY+dy);
        invalidate();
    }


    /**
     * Scroller.computeScrollOffset() 需要在动画期间循环调用
     * 回想一下 Android 常用的编程技巧，如果让一个自定义的 View 不断重绘，我们可以怎么做？
     *
     * 1.通过一个 Handler 不停地发送消息，在接收消息时调用 postInvalidate() 或者 invalidate()，然后延时再发送相同的消息。
     *
     * 2.在 onDraw() 方法中调用 postInvalidate() 方法，可以导致 onDraw() 方法不断重绘。
     *
     *
     *
     * 当调用 mScroller.startScroll() 时，我们马上调用了 invalidate() 方法，
     * 这样会导致重绘，重绘的过程中 computeScroll() 方法会被执行，
     * 而我们在 computeScrollOffset() 中获取了 Scroller 中的 mCurrentX 和 mCurrentY，
     * 然后通过 scrollTo() 方法设置了 mScrollX 和 mScrollY，这一过程本来会导致重绘，
     *
     * 但是如果 scrollTo() 里面的参数没有变化的话，那么就不会触发重绘，
     * 所以呢，我们又在后面代码补充了一个 postInvalidate() 方法的调用，
     * 当然，为了避免重复请求，可以在这个代码之前添加条件判断，判断的依据就是此次参数是不是和 mScrollX、mScrollY 相等
     *
     */
    @Override
    public void computeScroll() {
        super.computeScroll();
        if (scroller.computeScrollOffset()){
            Log.d(TAG, "computeScroll: ");

            //更新mScrollX 和mScrollY 的值（将scroller.getCurrX和 scroller.getCurrY 的值赋值给mScrollX 和mScrollY）
            scrollTo(scroller.getCurrX(),scroller.getCurrY());
            if (scroller.getCurrX() == getScrollX()
                    && scroller.getCurrY() == getScrollY() ) {
                postInvalidate();
            }

        }else {
            Log.d(TAG, "computeScroll is over: ");
        }

    }
}
