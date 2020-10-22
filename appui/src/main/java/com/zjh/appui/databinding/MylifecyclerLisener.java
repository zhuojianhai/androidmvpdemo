package com.zjh.appui.databinding;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

/**
 * 自定义生命周期的观察者对象
 * 在实现了LifecyclerOwner接口的类中注册观察者
 */
public class MylifecyclerLisener implements LifecycleObserver {

    public MylifecyclerLisener(){

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
   public void  onCreate(){
        System.out.println(">>>>>>oncreate");

   }

   @OnLifecycleEvent(Lifecycle.Event.ON_START)
   public void onStart(){
       System.out.println(">>>>>>onStart");

   }
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResum(){
        System.out.println(">>>>>>onResum");

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause(){
        System.out.println(">>>>>>onPause");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop(){
        System.out.println(">>>>>>onStop");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestory(){
        System.out.println(">>>>>>onDestory");
    }
}
