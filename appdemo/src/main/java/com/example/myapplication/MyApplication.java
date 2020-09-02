package com.example.myapplication;

import android.app.Application;
import android.content.Context;

import com.example.myapplication.hotfix.HotfixHelper;

import dalvik.system.BaseDexClassLoader;
import dalvik.system.DexClassLoader;
import dalvik.system.PathClassLoader;

public class MyApplication extends Application {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        HotfixHelper.applyPatch(base);
        BaseDexClassLoader dexClassLoader = new DexClassLoader("","","",null);
        BaseDexClassLoader pathClassLoader = new PathClassLoader("",base.getClassLoader());

    }
}
