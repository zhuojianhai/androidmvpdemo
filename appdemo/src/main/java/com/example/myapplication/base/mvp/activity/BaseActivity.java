package com.example.myapplication.base.mvp.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;

import com.example.myapplication.base.BaseView;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;


public class BaseActivity extends RxAppCompatActivity implements BaseView {

    protected Context mContext;
    protected Bundle mSavedInstanceState;

    /**
     * 动态权限申请
     */
//    protected U1CityPermission mPermission;

    /**
     * 沉浸式
     */
//    private U1CityImmersionBar mImmersionBar = null;

    /**
     * 数据变更智能刷新,变更后是否需要自动刷新数据,刷新后记得设置成false
     */
    private boolean mGoAutoRefresh = false;
    /**
     * 数据总条数不超过一页数据时是否隐藏底部加载更多结束文字
     */
    private boolean mHideLoadMoreEnd = true;

    /**
     * 用于网络请求的Dialog
     */
//    private IRequestLoad mRequestLoading;

    /**
     * 使用者定义并使用的广播
     */
    private BroadcastReceiver mOtherBroadcastReceiver;
    /**
     * 网络状态转变的广播
     */
    private BroadcastReceiver mConnectionChangeReceiver;
    /**
     * 使用者定义的广播意图过滤器
     */
    private IntentFilter mIntentFilter;

    //********抽象接口,这边不做过多的接口 start*********//

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        isNoActionBar();
        sereenOrientation();
//        setSoftInputMode();
        super.onCreate(savedInstanceState);
//        isLauncherTaskRoot(false);
        mContext = this;
        mSavedInstanceState = savedInstanceState;
//        initContentView();
    }


    @Override
    public void showRequestLoading() {

    }

    @Override
    public void dismissRequestLoading() {

    }

    @Override
    public void onRequestError(String error) {

    }

    @Override
    public void showToast(@NonNull String msg) {

    }

    @Override
    public void showToast(int resId) {

    }

    /**
     * 选择屏幕方向
     */
    @SuppressLint("SourceLockedOrientationActivity")
    private void sereenOrientation() {
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.O ) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
        }else{
            if (!isLandscape()) {
                //强制竖屏
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            } else {
                //强制横屏
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            }
        }

    }


    /**
     * 是否横屏
     *
     * @return
     */
    protected boolean isLandscape() {
        return false;
    }

}