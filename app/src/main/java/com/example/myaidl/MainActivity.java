package com.example.myaidl;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.example.myaidl.activities.CoordinatLayout1Activity;
import com.example.myaidl.activities.CoordinatLayout2Activity;
import com.example.myaidl.activities.CoordinatLayout3Activity;
import com.example.myaidl.activities.CoordinatLayout4Activity;
import com.example.myaidl.activities.CoordinatLayout5Activity;
import com.example.myaidl.activities.CoordinatLayoutDemoActivity;
import com.example.myaidl.activities.CustomerLayoutActivity;
import com.example.myaidl.activities.CustomerViewActivity;
import com.example.myaidl.activities.ScableImageViewActivity;
import com.example.myaidl.activities.TouchViewActivity;
import com.example.myaidl.bean.Book;
import com.example.myaidl.login.LoginActivity;
import com.example.myaidl.ui.main.PlaceholderFragment;
import com.example.myaidl.ui.main.PlaceholderFragment2;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.myaidl.ui.main.SectionsPagerAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dalvik.system.PathClassLoader;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private String TAG = "MainActivity";
    EditText num_et2;

    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button button10;
    Button button11;

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = findViewById(R.id.fab);

        initDataAndView(fab);

        RecyclerView recyclerView = new RecyclerView(this);

        Log.e(TAG, "onCreate: >>>>>>" );
        if (savedInstanceState!=null){
            String name = (String) savedInstanceState.get("name");
            Log.e(TAG, "onCreate: savedInstanceState ----" +name);
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(PlaceholderFragment.newInstance(1),"placeholderFragment");
//        transaction.add(PlaceholderFragment2.newInstance(2),"placeholderFragment2");
        transaction.commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart: >>>>>" );
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "onRestart: >>>>>>>" );
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e(TAG, "onSaveInstanceState: >>>>>>>>>>>>>>" );
        outState.putCharSequence("name","zhuojianahi");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume:>>>>>> " );
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause: >>>>>>>>>>>>>" );
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop: >>>>>>" );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: >>>>>>>>>>>>" );
    }


    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        StringBuilder sb = new StringBuilder();
        sb.append(newConfig.orientation);
        sb.append("\n");
        Log.e(TAG, "onConfigurationChanged: "+sb.toString() );
    }

    private void initDataAndView(FloatingActionButton fab) {
        num_et2 = findViewById(R.id.et);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                Intent intent = new Intent(MainActivity.this, CoordinatLayoutDemoActivity.class);
                startActivity(intent);
            }
        });

        button1 = findViewById(R.id.bt1);
        button2 = findViewById(R.id.bt2);
        button3 = findViewById(R.id.bt3);
        button4 = findViewById(R.id.bt4);
        button5 = findViewById(R.id.bt5);
        button6 = findViewById(R.id.bt6);
        button7 = findViewById(R.id.bt7);
        button8 = findViewById(R.id.bt8);
        button9 = findViewById(R.id.bt9);
        button10 = findViewById(R.id.bt10);
        button11 = findViewById(R.id.bt11);


        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button10.setOnClickListener(this);
        button11.setOnClickListener(this);

        final String pattern = "[^\\d+\\.?\\d{0,2}]";
        num_et2.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable edt) {
                String temp = edt.toString();
                if (Pattern.matches(pattern, temp)) {
                    int posDot = temp.indexOf(".");
                    if (posDot <= 0) return;
                    if (temp.length() - posDot - 1 > 2) {
                        edt.delete(posDot + 3, posDot + 4);
                    }
                }

            }

            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            }

            public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v == button1) {
            Intent intent = new Intent(MainActivity.this, CoordinatLayout1Activity.class);
            startActivity(intent);
        } else if (v == button2) {
            Intent intent = new Intent(MainActivity.this, CoordinatLayout2Activity.class);
            startActivity(intent);
        } else if (v == button3) {
            Intent intent = new Intent(MainActivity.this, CoordinatLayout3Activity.class);
            startActivity(intent);
        } else if (v == button4) {
            Intent intent = new Intent(MainActivity.this, CoordinatLayout4Activity.class);
            startActivity(intent);
        } else if (v == button5) {
            Intent intent = new Intent(MainActivity.this, CoordinatLayout5Activity.class);
            startActivity(intent);

        } else if (v == button6) {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);

        }else if (v == button7) {
            Intent intent = new Intent(MainActivity.this, CustomerViewActivity.class);
            startActivity(intent);

        }else if (v == button8) {
            Intent intent = new Intent(MainActivity.this, CustomerLayoutActivity.class);
            startActivity(intent);

        }else if (v == button9) {
            Intent intent = new Intent(MainActivity.this, TouchViewActivity.class);
            startActivity(intent);

        }else if (v == button10) {
            Intent intent = new Intent(MainActivity.this, ScableImageViewActivity.class);
            startActivity(intent);

        }else if (v == button11) {
//            Intent intent = new Intent(MainActivity.this, ScableImageViewActivity.class);
//            startActivity(intent);

            ARouter.getInstance().build("/com/zjh/module/home/ui/login").navigation();

            FragmentManager f = getSupportFragmentManager();
            FragmentTransaction ft = f.beginTransaction();
           Fragment fragment =  f.findFragmentByTag("placeholderFragment");
           ft.setMaxLifecycle(fragment, Lifecycle.State.DESTROYED);


           ViewPager viewPager = new ViewPager(this);
           viewPager.setAdapter(new MyPagerAdapter());


            SurfaceView surfaceView = new SurfaceView(this);


        }
    }

    class  MyPagerAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return false;
        }
    }

    private void showRXjavademo() {
        final Disposable[] mDisposable = new Disposable[1];
        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {

            }
        });
        observable = observable.map(new Function<String, String>() {
            @Override
            public String apply(String s) throws Exception {
                return s.toUpperCase();
            }
        }).filter(new Predicate<String>() {
            @Override
            public boolean test(String s) throws Exception {
                return !s.isEmpty();
            }
        });

        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                mDisposable[0] = d;
            }

            @Override
            public void onNext(String s) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

        observable.subscribe(observer);


        Gson gson = new Gson();
        gson.fromJson("", Book.class);

        Type list = new TypeToken<List<String>>() {
        }.getType();


        PathClassLoader pathClassLoader = new PathClassLoader();

    }

    private void showImage() {

        ImageView img = new ImageView(this);
        Glide.with(this).load("").placeholder(R.drawable.ic_launcher_background).fitCenter().into(img);


        Glide.with(this).load("").listener(new RequestListener<Drawable>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                return false;
            }

            @Override
            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                return false;
            }
        }).into(img);


        Glide.get(this).clearMemory();//清理内存缓存 可以在UI主线程中进行

        new Thread(new Runnable() {
            @Override
            public void run() {
                Glide.get(MainActivity.this).clearDiskCache();//清理磁盘缓存 需要在子线程中执行
            }
        }).start();

        Glide.with(this).applyDefaultRequestOptions(new RequestOptions());
    }

    @SuppressLint("ResourceType")
    private void showBitmap(){
        InputStream inputStream = null;
        BitmapRegionDecoder decoder = null;
        try {
            inputStream = getResources().openRawResource(R.drawable.avatar_rengwuxian);
            decoder  = BitmapRegionDecoder.newInstance(inputStream,false);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inMutable = true;
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;

            Rect rect = new Rect();
            rect.left = 0;
            rect.top = 0;
            rect.right = 100;
            rect.bottom = 100;

            decoder.decodeRegion(rect,options);

        }catch (Exception e){
            e.printStackTrace();

        }finally {
            if (inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}