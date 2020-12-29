package com.example.myapplication.login;

import com.example.myapplication.base.BaseModel;

/**
 * 
 * @author zhuojianhai
 * time 2020/12/29 11:59
 * 维护者 
 */
public class LoginModel extends BaseModel<LoginPresenter,ILogin.LoginM> {
    public LoginModel(LoginPresenter mPresenter) {
        super(mPresenter);
    }

    @Override
    public ILogin.LoginM getContract() {
        return new ILogin.LoginM() {
            @Override
            public void login(String name, String password) {
                /**
                 * 模拟网络请求成功，
                 * 调用presenter层的回调接口
                 */
                mPresenter.getContract().loginResult(true);
            }
        };
    }
}