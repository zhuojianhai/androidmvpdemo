package com.example.myaidl.custom;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class TagLayout extends ViewGroup {


    //记录每一行的高度
    List<Integer> lineHeights = new ArrayList<Integer>();

    List<List<View>> views = new ArrayList<>();

    public TagLayout(Context context) {
        super(context);
    }

    public TagLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /***
     * 测量布局
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);

        int modeWidth = MeasureSpec.getMode(widthMeasureSpec);
        int modeHeight = MeasureSpec.getMode(heightMeasureSpec);

        int width   =  0;//宽度等于所有行里宽度最宽的一行
        int height = 0;//所有行的高度相加

        int lineWidth = 0;//一行宽度 = 一行中所有view宽度之和
        int lineHeight = 0;//一行高 = 一行中所有view最高的那个

        int childCount = getChildCount();
        for(int i=0;i<childCount;i++){
            View child = getChildAt(i);
            measureChildWithMargins(child,widthMeasureSpec,0,heightMeasureSpec,0);
            MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();

            //得到子控件真实占用的宽和高
            int childWidth = child.getMeasuredWidth() + lp.leftMargin + lp.rightMargin;
            int childHeight = child.getMeasuredHeight() + lp.topMargin + lp.bottomMargin;

            //判断是否需要换行--当前已经使用的宽度+当前view宽度是否大于父控件的宽度
            if(lineWidth + childWidth >sizeWidth){

                width = Math.max(lineWidth,width);
                lineWidth = childWidth;
                height = height+lineHeight;

                lineHeight = childHeight;
            }else{ //宽度累加

                lineWidth = lineWidth + childWidth;
                lineHeight = Math.max(lineHeight,childHeight);
            }

            //最后一步
            if(i == childCount -1){
                width = Math.max(width,lineWidth);
                height = height+lineHeight;
            }

        }

        int measuredWidth = (modeWidth == MeasureSpec.EXACTLY)?sizeWidth:width;
        int measuredHeight = (modeHeight == MeasureSpec.EXACTLY)?sizeHeight:height;
        setMeasuredDimension(measuredWidth,measuredHeight);
    }

    /**
     * viewgorup 中view 如何摆放，这里说了算
     * @param changed
     * @param l
     * @param t
     * @param r
     * @param b
     */
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        views.clear();
        lineHeights.clear();

        //计算该行有多少列数据
        List<View> lineViews = new ArrayList<>();
        //容器自己的宽度
        int widht = getMeasuredWidth();
        int lineWidth = 0 ;
        int lineHeight = 0;

        int childCount = getChildCount();

        for (int i=0;i<childCount;i++){

            View child = getChildAt(i);
            MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();
            int childWidth = child.getMeasuredWidth();
            int childHeight = child.getMeasuredHeight();

            //判断超出换行
            if((childWidth + lp.leftMargin + lp.rightMargin +lineWidth)>widht){

                lineHeights.add(lineHeight);
                views.add(lineViews);
                lineWidth = 0;
                lineHeight = 0;
                lineViews = new ArrayList<>();
            }


            lineWidth +=childWidth+lp.leftMargin + lp.rightMargin;
            lineHeight = Math.max(lineHeight,childHeight+lp.topMargin+lp.bottomMargin);
            lineViews.add(child);
        }

        lineHeights.add(lineHeight);
        views.add(lineViews);
        int left = 0;
        int top = 0;
        int size = views.size();

        for(int i = 0;i<size;i++){
            lineViews = views.get(i);
            lineHeight = lineHeights.get(i);

            for(int j=0;j<lineViews.size();j++){
                //遍历这一行的所有的child
                View child = lineViews.get(j);
                MarginLayoutParams lp = (MarginLayoutParams)child.getLayoutParams();
                int lc = left+lp.leftMargin;
                int tc = top + lp.topMargin;
                int rc = lc+child.getMeasuredWidth();
                int bc = tc + child.getMeasuredHeight();

                child.layout(lc,tc,rc,bc);
                left+= child.getMeasuredWidth() + lp.rightMargin+ lp.leftMargin;

            }
            left = 0;
            top+=lineHeight;
        }


    }

    @Override
    protected LayoutParams generateLayoutParams(LayoutParams p) {
        return new MarginLayoutParams(p);
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(),attrs);
    }
}
