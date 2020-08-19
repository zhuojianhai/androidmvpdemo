package com.zjh.appui;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class ActivityLifecycleObserver implements LifecycleObserver {
    private String TAG = "ActivityLifecycleObserver";
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void onCreate(){
        Log.e(TAG, "onCreate: 监听" );

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    void onStart(){
        Log.e(TAG, "onStart: 监听" );
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    void onResume(){
        Log.e(TAG, "onResume: 监听" );
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    void onPause(){
        Log.e(TAG, "onPause: 监听" );
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    void onStop(){
        Log.e(TAG, "onStop: 监听" );
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void onDestory(){
        Log.e(TAG, "onDestory: 监听" );
    }


}
