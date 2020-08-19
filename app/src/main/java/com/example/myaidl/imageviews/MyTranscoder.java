package com.example.myaidl.imageviews;

import android.graphics.Bitmap;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.BitmapCompat;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bytes.BytesResource;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;

import java.io.ByteArrayOutputStream;

/**
 * Glide 自定义 Transcoder
 */
public class MyTranscoder implements ResourceTranscoder<Bitmap, byte[]> {
    private final Bitmap.CompressFormat compressFormat;
    private final int quality;


    public MyTranscoder(){

        this(Bitmap.CompressFormat.JPEG, 100);
    }

    public MyTranscoder(Bitmap.CompressFormat compressFormat,int quality){
        this.compressFormat = compressFormat;
        this.quality = quality;

    }

    @Nullable
    @Override
    public Resource<byte[]> transcode(@NonNull Resource<Bitmap> toTranscode, @NonNull Options options) {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        toTranscode.get().compress(compressFormat,quality,os);
        toTranscode.recycle();

        BytesResource bytesResource = new BytesResource(os.toByteArray());
        return bytesResource;
    }

    private void ssss(){

    }
}
