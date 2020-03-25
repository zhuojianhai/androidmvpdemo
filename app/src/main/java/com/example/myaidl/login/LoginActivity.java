package com.example.myaidl.login;


import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myaidl.R;
import com.example.myaidl.base.BaseActivity;
import com.example.myaidl.bean.Movie;
import com.example.myaidl.movie.MovieActivity;
import com.example.myaidl.network.ApiMethods;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


public class LoginActivity extends BaseActivity<LoginPresenter,ILoginContract.LoginView> {

    String TAG = "LoginActivity";

    EditText name;

    EditText pwd;

    Button login;
    Button bt_retrofit;



    @Override
    public ILoginContract.LoginView getContract() {
        return new ILoginContract.LoginView() {
            @Override
            public void requestLoginResult(boolean result) {
                if(result){

                Toast.makeText(LoginActivity.this,"login success",Toast.LENGTH_LONG).show();


                }else{
                Toast.makeText(LoginActivity.this,"login fail",Toast.LENGTH_LONG).show();

                }

            }
        };
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
         name = findViewById(R.id.edit_name);
         pwd = findViewById(R.id.edit_pwd);
        login =  findViewById(R.id.bt_login);
        bt_retrofit =  findViewById(R.id.bt_retrofit);

    }

    @Override
    protected void initEvent() {

        login.setOnClickListener(this);
        bt_retrofit.setOnClickListener(this);
    }

    @Override
    protected LoginPresenter getmPresenterInstatnce() {
        return new LoginPresenter(this);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_login;
    }

    @Override
    protected void destory() {

    }

    @Override
    public void onClick(View v) {

        if(v==login){
            String loginName = name.getText().toString();
            String longinPwd = pwd.getText().toString();
            getmPresenterInstatnce().getContract().requestLogin(loginName,longinPwd);
        }else if(v == bt_retrofit){
            showMovies();
        }
    }

    private void showMovies(){
        Observer<Movie> observer = new Observer<Movie>() {
            @Override
            public void onSubscribe(Disposable d) {
                    Log.d(TAG, "onSubscribe: ");
            }

            @Override
            public void onNext(Movie movie) {
                Log.d(TAG, "onNext: " + movie.getTitle());
                List<Movie.Subjects> list = movie.getSubjects();
                for (Movie.Subjects sub : list) {
                    Log.d(TAG, "onNext: " + sub.getId() + "," + sub.getYear() + "," + sub.getTitle());
                }

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Intent intent = new Intent(LoginActivity.this, MovieActivity.class);
                startActivity(intent);
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError: " + e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: Over!");
            }
        };
        ApiMethods.getTopMovie(observer,0,10);
    }
}
