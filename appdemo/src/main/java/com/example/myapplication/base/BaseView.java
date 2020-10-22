package com.example.myapplication.base;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;

public interface BaseView {
    /**
     * 展示网络请求Loading
     */
    void showRequestLoading();

    /**
     * 关闭网络请求Loading
     */
    void dismissRequestLoading();

    /**
     * 网络请求异常
     *
     * @param error
     */
    void onRequestError(String error);

    /**
     * 弹出吐司
     *
     * @param msg
     */
    void showToast(@NonNull String msg);

    /**
     * 弹出吐司
     *
     * @param resId
     */
    void showToast(@StringRes final int resId);
}
