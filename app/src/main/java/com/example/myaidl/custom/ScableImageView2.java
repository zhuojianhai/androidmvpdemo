package com.example.myaidl.custom;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.core.view.GestureDetectorCompat;

import com.example.myaidl.utils.Utils;

public class ScableImageView2 extends View implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {
    private static final float IMAGE_WIDTH = Utils.dpToPixel(300);
    private static final float OVER_SCALE_FACTOR = 1.5f;
    Bitmap bitmap;
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    float originalOffsetX;
    float originalOffsetY;

    float offsetX;
    float offsetY;

    float smallScale;
    float bigScale;
    /**
     * 这个变量有两个作用
     *  1、绘制控制大小
     *  2、双击控制大小
     */
    boolean big;

    /**
     * 这个属性的增加，控制绘制的大小。解耦big的功能
     */
    float  scaleFraction ;//0~1 动画属性

    public float getScaleFraction() {
        return scaleFraction;
    }

    public void setScaleFraction(float scaleFraction) {
        this.scaleFraction = scaleFraction;
        invalidate();
    }




    ObjectAnimator objectAnimator;

    GestureDetectorCompat gestureDetectorCompat;

    public ScableImageView2(Context context) {
        super(context);
    }

    public ScableImageView2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        bitmap = Utils.getAvatar(getResources(),(int)IMAGE_WIDTH);
        gestureDetectorCompat = new GestureDetectorCompat(context,this);

        gestureDetectorCompat.setOnDoubleTapListener(this);
    }


    private ObjectAnimator getScaleAnimator(){
        if(objectAnimator == null){
            objectAnimator = ObjectAnimator.ofFloat(this,"scaleFraction",0,1);
        }
        return  objectAnimator;
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetectorCompat.onTouchEvent(event);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        originalOffsetX =(float)( (getWidth() - bitmap.getWidth())/2);
        originalOffsetY =(float) ((getHeight() - bitmap.getHeight())/2);

        /**
         *图片的宽高比，比view的宽高比大
         * 下面的比值没有转换成float 导致高度会有一段留白 算是bug
         */

        if(bitmap.getWidth()/bitmap.getHeight() > getWidth()/getHeight()){
            smallScale = getWidth()/bitmap.getWidth();
            bigScale = getHeight()/bitmap.getHeight();
        }else{
            smallScale = getHeight()/bitmap.getHeight();
            bigScale = getWidth() / bitmap.getWidth();
        }

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.translate(offsetX,offsetY);
        float sacle = smallScale+(bigScale-smallScale)*scaleFraction;
        System.out.println("scale " +sacle);
        canvas.scale(sacle,sacle,getWidth()/2f,getHeight()/2f);
        canvas.drawBitmap(bitmap,originalOffsetX,originalOffsetY,paint);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    //手一抬起来就响应方法回调
    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    /**
     * 其实就是onMove 事假
     * @param e1
     * @param e2
     * @param distanceX  旧位置的x值 - 新位置的X值
     * @param distanceY
     * @return
     */
    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        if (big){
            offsetX-=distanceX;
            offsetY-=distanceY;
            invalidate();
        }

        return false;
    }

    // 600毫秒  原生的是500毫秒
    @Override
    public void onLongPress(MotionEvent e) {

    }

    // 手指滑动抬起了，也就是惯性滑动
    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }


    /*onDoubleTapListener start*/

    //双击之前的一次单击确定边界
    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        return false;
    }

    // 默认  300毫秒之内确定 是不是双击
    @Override
    public boolean onDoubleTap(MotionEvent e) {
        big = !big;
        if(big){
            getScaleAnimator().start();
        }else{
            getScaleAnimator().reverse();
        }

        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        return false;
    }
    /*onDoubleTapListener end*/
}
