package com.example.myapplication.login;

import com.example.myapplication.base.BasePresenter;

/**
 * 
 * @author zhuojianhai
 * time 2020/12/29 11:58
 * 维护者 
 */
public class LoginPresenter extends BasePresenter<LoginActivity,LoginModel,ILogin.LoginVP> {
    @Override
    protected LoginModel getModelInstance() {
        return new LoginModel(this);
    }

    @Override
    public ILogin.LoginVP getContract() {
        return new ILogin.LoginVP() {
            @Override
            public void login(String name, String password) {
                mModel.getContract().login(name,password);
            }

            @Override
            public void loginResult(boolean result) {
                mView.getContract().loginResult(result);
            }
        };
    }
}