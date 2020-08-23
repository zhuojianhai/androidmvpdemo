package com.zjh.appui.util;

import android.view.View;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class RxView {
    String TAG = RxView.class.getSimpleName();
    public static Observable<Object> clicks(View view){

        return new ViewClickObserable(view);
    }


}
