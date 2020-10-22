package com.zjh.appui.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.zjh.appui.R;

public class Myworker extends Worker {
    public Myworker(
            @NonNull Context appContext,
            @NonNull WorkerParameters workerParams) {
        super(appContext, workerParams);
    }
    @NonNull
    @Override
    public Worker.Result doWork() {

        Context applicationContext = getApplicationContext();

        try {

            Bitmap picture = BitmapFactory.decodeResource(
                    applicationContext.getResources(),
                    R.drawable.ic_launcher_background);




            return Worker.Result.success();

        } catch (Throwable throwable) {

            return Worker.Result.failure();

        }
    }
}
