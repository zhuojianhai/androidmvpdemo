package com.example.myaidl.hookactivity;

import android.app.Activity;
import android.app.Instrumentation;

import com.example.myaidl.hookactivity.hook1.ActivityProxyInstrumentation;

import java.lang.reflect.Field;

public class HookHelper {

    /**
     * 第一步：拿到当前 activity 的 mInstrumentation
     * 第二步：创建代理对象
     * 第三步：将我们的代理替换原 activity 的 mInstrumentation
     * @param activity
     */
    public static void replaceInstrumentation(Activity activity) throws Exception{
        Class<?> k = Activity.class;
        Field field = k.getDeclaredField("mInstrumentation");
        field.setAccessible(true);
        //根据activity内mInstrumentation字段 获取Instrumentation对象
        Instrumentation instrumentation = (Instrumentation)field.get(activity);

        Instrumentation  instrumentationProxy = new ActivityProxyInstrumentation(instrumentation);

        field.set(activity,instrumentationProxy);


    }
}
