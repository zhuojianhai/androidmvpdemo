package com.zjh.appui.util;

import android.content.Context;
import android.util.DisplayMetrics;

public class Utils {
    public static void DisplayInfo(Context context){
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float density = displayMetrics.density;
        float densityDpi = displayMetrics.densityDpi;

        //字体的缩放因子，正常情况下和density相等，但是调节系统字体大小后会改变这个值
        float scaledDensity = displayMetrics.scaledDensity;


    }
}
