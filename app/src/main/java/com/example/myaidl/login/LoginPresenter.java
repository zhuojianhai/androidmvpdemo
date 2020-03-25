package com.example.myaidl.login;

import com.example.myaidl.base.BaseActivity;
import com.example.myaidl.base.BasePresenter;

public class LoginPresenter extends BasePresenter<LoginActivity,LoginModel,ILoginContract.LoginPresenter> {
    public LoginPresenter(){
        super();
    }
    public LoginPresenter(LoginActivity baseActivity){
        super(baseActivity);
    }
    @Override
    protected LoginModel getmModelInstance() {
        return new LoginModel(this);
    }

    @Override
    public ILoginContract.LoginPresenter getContract() {
        return new ILoginContract.LoginPresenter() {
            @Override
            public void requestLogin(String name, String pwd) {

                mModel.getContract().requestLogin(name,pwd);
            }

            @Override
            public void requestLoginResult(boolean result) {
                mView.getContract().requestLoginResult(result);
            }
        };
    }
}
