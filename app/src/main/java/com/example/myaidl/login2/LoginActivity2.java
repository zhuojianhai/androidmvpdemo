package com.example.myaidl.login2;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myaidl.R;
import com.example.myaidl.base.BaseActivity;


public class LoginActivity2 extends BaseActivity<LoginPresenter2,ILogin.VP> {


    EditText name;
    EditText pwd;
    Button login;

    @Override
    public ILogin.VP getContract() {
        return new ILogin.VP() {
            @Override
            public void requestLogin(String name, String pwd) {
                mPresenter.getContract().requestLogin(name,pwd);

            }

            @Override
            public void requestLoginResult(boolean loginResult) {

                Toast.makeText(LoginActivity2.this,"request result is "+loginResult,Toast.LENGTH_LONG).show();
            }
        };
    }

    @Override
    public LoginPresenter2 getmPresenterInstance() {
        return new LoginPresenter2();
    }

    @Override
    protected void initData() {

    }

    @Override
    public void initViews() {
        name = findViewById(R.id.edit_name);
        pwd = findViewById(R.id.edit_pwd);
        login = findViewById(R.id.bt_login);

    }

    @Override
    public void initListener() {
        login.setOnClickListener(this);
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_login;
    }

    @Override
    public void onDestory() {
        mPresenter.unBindview();

    }

    @Override
    public void responseError(Object o, Throwable throwable) {

    }


    @Override
    public void onClick(View v) {
        if(v==login){
            String names =    name.getText().toString();
            String pwds =  pwd.getText().toString();

            getContract().requestLogin(names,pwds);
        }

    }
}
