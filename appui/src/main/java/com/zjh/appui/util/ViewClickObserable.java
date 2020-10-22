package com.zjh.appui.util;

import android.os.Looper;
import android.view.View;
import java.util.concurrent.atomic.AtomicBoolean;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class ViewClickObserable extends Observable<Object> {
    private final View view;
    private static final Object EVENT = new Object();
    private static  Object EVENT2 = null;
    public ViewClickObserable(View view){
        this.view = view;
        EVENT2 = view;
    }
    @Override
    protected void subscribeActual(Observer<? super Object> observer) {

        MyListener listener = new MyListener(view,observer);
        observer.onSubscribe(listener);
        this.view.setOnClickListener(listener);
    }

    //包裹
    static final class MyListener implements View.OnClickListener, Disposable {
        private final View view;
        private Observer<Object> observer;//存一份，下游

        //原子性boolean
        private AtomicBoolean isDisposable = new AtomicBoolean();
        public MyListener(View view, Observer<? super Object> observer) {
            this.view = view;
            this.observer = observer;
        }

        @Override
        public void onClick(View v) {
            if (isDisposed()== false){
                observer.onNext(EVENT);
            }

        }

        //如果调用了中断
        @Override
        public void dispose() {

            //如果没有中断过，才有资格中断
            if (isDisposable.compareAndSet(false,true)){
                //主线程很好，中断
                if (Looper.getMainLooper() == Looper.myLooper()){
                    view.setOnClickListener(null);
                }else{//子线程通过handler切换

                    AndroidSchedulers.mainThread().scheduleDirect(new Runnable() {
                        @Override
                        public void run() {
                            view.setOnClickListener(null);
                        }
                    });

                }
            }
        }

        @Override
        public boolean isDisposed() {
            return isDisposable.get();
        }
    }
}
