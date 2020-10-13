package com.example.myapplication.base.mvp;

import androidx.annotation.NonNull;
import androidx.annotation.UiThread;

public interface MvpPresenter<V extends MvpView> {
    /**
     * 绑定UI层
     * @param view
     */
    @UiThread
    void attachView(@NonNull V view);

    /**
     * 解绑UI层
     */
    @UiThread
    void detachView();

    /**
     * 销毁Model层
     */
    @UiThread
    void destroy();
}
