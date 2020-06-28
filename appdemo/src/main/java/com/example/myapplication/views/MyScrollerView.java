//package com.example.myapplication.views;
//
//import android.content.Context;
//import android.content.res.TypedArray;
//import android.graphics.Canvas;
//import android.graphics.Color;
//import android.graphics.Paint;
//import android.graphics.drawable.Drawable;
//import android.text.TextPaint;
//import android.util.AttributeSet;
//import android.view.View;
//import android.widget.Scroller;
//
//import com.example.myapplication.R;
//
///**
// * TODO: document your custom view class.
// */
//public class MyScrollerView extends View {
//    private String mExampleString; // TODO: use a default from R.string...
//    private int mExampleColor = Color.RED; // TODO: use a default from R.color...
//    private float mExampleDimension = 0; // TODO: use a default from R.dimen...
//    private Drawable mExampleDrawable;
//
//    private TextPaint mTextPaint;
//    private float mTextWidth;
//    private float mTextHeight;
//
//
//    Scroller mScroller = null;
//
//    public MyScrollerView(Context context) {
//        super(context);
//        init(null, 0);
//    }
//
//    public MyScrollerView(Context context, AttributeSet attrs) {
//        super(context, attrs);
//        init(attrs, 0);
//    }
//
//    public MyScrollerView(Context context, AttributeSet attrs, int defStyle) {
//        super(context, attrs, defStyle);
//        init(attrs, defStyle);
//    }
//
//    private void init(AttributeSet attrs, int defStyle) {
//        // Load attributes
//        final TypedArray a = getContext().obtainStyledAttributes(
//                attrs, R.styleable.MyScrollerView, defStyle, 0);
//
//        mExampleString = a.getString(
//                R.styleable.MyScrollerView_exampleString);
//        mExampleColor = a.getColor(
//                R.styleable.MyScrollerView_exampleColor,
//                mExampleColor);
//        // Use getDimensionPixelSize or getDimensionPixelOffset when dealing with
//        // values that should fall on pixel boundaries.
//        mExampleDimension = a.getDimension(
//                R.styleable.MyScrollerView_exampleDimension,
//                mExampleDimension);
//
//        if (a.hasValue(R.styleable.MyScrollerView_exampleDrawable)) {
//            mExampleDrawable = a.getDrawable(
//                    R.styleable.MyScrollerView_exampleDrawable);
//            mExampleDrawable.setCallback(this);
//        }
//
//        a.recycle();
//
//        // Set up a default TextPaint object
//        mTextPaint = new TextPaint();
//        mTextPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
//        mTextPaint.setTextAlign(Paint.Align.LEFT);
//
//        // Update TextPaint and text measurements from attributes
//        invalidateTextPaintAndMeasurements();
//
//        mScroller = new Scroller(getContext());
//    }
//
//    private void invalidateTextPaintAndMeasurements() {
//        mTextPaint.setTextSize(mExampleDimension);
//        mTextPaint.setColor(mExampleColor);
//        mTextWidth = mTextPaint.measureText(mExampleString);
//
//        Paint.FontMetrics fontMetrics = mTextPaint.getFontMetrics();
//        mTextHeight = fontMetrics.bottom;
//    }
//
//    @Override
//    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//
//        // allocations per draw cycle.
//        int paddingLeft = getPaddingLeft();
//        int paddingTop = getPaddingTop();
//        int paddingRight = getPaddingRight();
//        int paddingBottom = getPaddingBottom();
//
//        int contentWidth = getWidth() - paddingLeft - paddingRight;
//        int contentHeight = getHeight() - paddingTop - paddingBottom;
//
//        // Draw the text.
//        canvas.drawText(mExampleString,
//                paddingLeft + (contentWidth - mTextWidth) / 2,
//                paddingTop + (contentHeight + mTextHeight) / 2,
//                mTextPaint);
//
//        // Draw the example drawable on top of the text.
//        if (mExampleDrawable != null) {
//            mExampleDrawable.setBounds(paddingLeft, paddingTop,
//                    paddingLeft + contentWidth, paddingTop + contentHeight);
//            mExampleDrawable.draw(canvas);
//        }
//    }
//
//
//    public String getExampleString() {
//        return mExampleString;
//    }
//
//
//    public void setExampleString(String exampleString) {
//        mExampleString = exampleString;
//        invalidateTextPaintAndMeasurements();
//    }
//
//
//    public int getExampleColor() {
//        return mExampleColor;
//    }
//
//
//    public void setExampleColor(int exampleColor) {
//        mExampleColor = exampleColor;
//        invalidateTextPaintAndMeasurements();
//    }
//
//
//    public float getExampleDimension() {
//        return mExampleDimension;
//    }
//
//
//    public void setExampleDimension(float exampleDimension) {
//        mExampleDimension = exampleDimension;
//        invalidateTextPaintAndMeasurements();
//    }
//
//
//    public Drawable getExampleDrawable() {
//        return mExampleDrawable;
//    }
//
//
//    public void setExampleDrawable(Drawable exampleDrawable) {
//        mExampleDrawable = exampleDrawable;
//    }
//
//
//    /**
//     *
//     */
//    private void showScrollerMethods(){
//        mScroller.getCurrX(); //获取mScroller当前水平滚动的位置
//        mScroller.getCurrY(); //获取mScroller当前竖直滚动的位置
//        mScroller.getFinalX(); //获取mScroller最终停止的水平位置
//        mScroller.getFinalY(); //获取mScroller最终停止的竖直位置
//        mScroller.setFinalX(100); //设置mScroller最终停留的水平位置，没有动画效果，直接跳到目标位置
//        mScroller.setFinalY(100); //设置mScroller最终停留的竖直位置，没有动画效果，直接跳到目标位置
//
//        //滚动，startX, startY为开始滚动的位置，dx,dy为滚动的偏移量, duration为完成滚动的时间
//        mScroller.startScroll(100, 100, 10, 10); //使用默认完成时间250ms
//        mScroller.startScroll(100, 100, 10, 10, 1000);
//
//        mScroller.computeScrollOffset(); //返回值为boolean，true说明滚动尚未完成，false说明滚动已经完成。这是一个很重要的方法，通常放在View.computeScroll()中，用来判断是否滚动是否结束。
//        mScroller.timePassed(); //返回当前已经消耗的事件
//        mScroller.isFinished();//动画是否已经停止
//        mScroller.forceFinished(true);//强制停止该动画
//        mScroller.abortAnimation();//aborting the animating cause the scroller to move to the final x and y
//    }
//}
