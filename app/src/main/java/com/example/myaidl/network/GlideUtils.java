package com.example.myaidl.network;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.manager.RequestManagerRetriever;

public class GlideUtils {

    public void loadImge(Context context, String url, ImageView img){

        Glide.with(context).load(url).thumbnail(0.1f).format(DecodeFormat.PREFER_ARGB_8888).into(img);



        int thumbnailSize = 1;
        Glide.with(context)
                .load(url)
                .thumbnail(
                        Glide.with(context)
                        .load(url)
                        .override(thumbnailSize)
                )

                .into(img);


        Glide.get(context).clearMemory();
        Glide.get(context).clearDiskCache();
        RequestManagerRetriever requestManagerRetriever = Glide.get(context).getRequestManagerRetriever();

    }
}
