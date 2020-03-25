package com.example.myaidl.login;


import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myaidl.R;
import com.example.myaidl.base.BaseActivity;


public class LoginActivity extends BaseActivity<LoginPresenter,ILoginContract.LoginView> {


    EditText name;

    EditText pwd;

    Button login;


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

    }

    @Override
    protected void initEvent() {

        login.setOnClickListener(this);
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
        }
    }
}
