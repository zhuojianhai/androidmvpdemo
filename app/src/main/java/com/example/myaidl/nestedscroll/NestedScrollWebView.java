package com.example.myaidl.nestedscroll;

import android.content.Context;
import android.util.AttributeSet;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.webkit.WebView;
import android.widget.Scroller;

import androidx.annotation.Nullable;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChildHelper;

/***
 *
 */
public class NestedScrollWebView extends WebView implements NestedScrollingChild2 {

    private final int[] mScrollConsumed = new int[2];
    private NestedScrollingChildHelper childHelper;
    private NestedWebViewRecyclerViewGroup parent;

    private VelocityTracker velocityTracker;
    private Scroller scroller;

    private boolean isSelfFling;
    private boolean hasFling;
    private final float density;
    private int mWebViewContentHeight;
    private int mMaximumVelocity;
    private int maxScrollY;
    private int TouchSlop;
    private int firstY;
    private int lastY;


    public NestedScrollWebView(Context context) {
        this(context,null);
    }

    public NestedScrollWebView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }
    public NestedScrollWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inits();
    }

    private void inits(){
        childHelper = new NestedScrollingChildHelper(this);

        setNestedScrollingEnabled(true);

        scroller = new Scroller(getContext());

        ViewConfiguration configuration = ViewConfiguration.get(getContext());

        mMaximumVelocity = configuration.getScaledMaximumFlingVelocity();

        density = getResources().getDisplayMetrics().density;

        //TouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        TouchSlop = Utils.dip2px(3);
    }


    @Override
    public boolean startNestedScroll(int axes, int type) {
        return false;
    }

    @Override
    public void stopNestedScroll(int type) {

    }

    @Override
    public boolean hasNestedScrollingParent(int type) {
        return false;
    }

    @Override
    public boolean dispatchNestedScroll(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, @Nullable int[] offsetInWindow, int type) {
        return false;
    }

    @Override
    public boolean dispatchNestedPreScroll(int dx, int dy, @Nullable int[] consumed, @Nullable int[] offsetInWindow, int type) {
        return false;
    }
}
