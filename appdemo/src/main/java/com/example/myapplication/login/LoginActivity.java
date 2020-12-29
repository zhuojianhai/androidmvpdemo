package com.example.myapplication.login;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.base.BaseActivity;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends BaseActivity<LoginPresenter,ILogin.LoginVP> implements View.OnClickListener{


    Button login;
    TextInputEditText userName;
    TextInputEditText userPwd;

    @Override
    protected ILogin.LoginVP getContract() {
        return new ILogin.LoginVP() {
            @Override
            public void login(String name, String password) {
                mPresenter.getContract().login(name,password);

            }

            @Override
            public void loginResult(boolean result) {
                //请求成功的回调
                Toast.makeText(LoginActivity.this,"success",Toast.LENGTH_LONG).show();

            }
        };
    }

    @Override
    protected LoginPresenter getmPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_login;
    }

    @Override
    protected void initData() {
        login = findViewById(R.id.button);
        userName = findViewById(R.id.tx_input_name);
        userPwd = findViewById(R.id.tx_input_pwd);

        login.setOnClickListener(this);
    }

    @Override
    protected void destory() {

    }

    @Override
    public void onClick(View v) {
        if (v == login){
            String name = userName.getText().toString();
            String pwd = userPwd.getText().toString();
            getContract().login(name,pwd);
        }
    }
}