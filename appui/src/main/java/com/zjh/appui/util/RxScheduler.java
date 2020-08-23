package com.zjh.appui.util;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RxScheduler {

    /**
     * 切换线程的统一封装
     */
    static final ObservableTransformer OBSERVABLE_TRANSFORMER = new ObservableTransformer() {
        @Override
        public ObservableSource apply(Observable upstream) {
            return upstream
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread());
        }
    };
    public static <T> ObservableTransformer<T,T> applyScheduler(){

        return OBSERVABLE_TRANSFORMER;
    }
}
