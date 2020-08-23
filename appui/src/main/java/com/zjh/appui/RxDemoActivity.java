package com.zjh.appui;

import androidx.appcompat.app.AppCompatActivity;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.zjh.appui.util.RxScheduler;
import com.zjh.appui.util.RxView;

import java.util.concurrent.TimeUnit;

public class RxDemoActivity extends AppCompatActivity {

    private String TAG= RxDemoActivity.class.getSimpleName();
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_demo);
        btn = findViewById(R.id.bt_rx_click);
        RxView.clicks(btn)
                .throttleFirst(2000, TimeUnit.MICROSECONDS)
                .subscribe(new Consumer<Object>() {

                    @Override
                    public void accept(Object o) throws Exception {
                        mylogic();
                    }
                });
    }

    private void mylogic(){
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("zhuojianhai");
            }
        }).compose(RxScheduler.applyScheduler())
                .subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {
                Log.e(TAG, "onNext: 接受到btn 值" );
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}
