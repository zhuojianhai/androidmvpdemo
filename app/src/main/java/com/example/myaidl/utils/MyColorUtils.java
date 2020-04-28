package com.example.myaidl.utils;


import android.graphics.Color;

import androidx.core.graphics.ColorUtils;

public class MyColorUtils {

    public static int getMixColor(int color,int color1,int ratio){
        int blendCorlor = ColorUtils.blendARGB(color, color1, ratio);
        return  blendCorlor;
    }
}
