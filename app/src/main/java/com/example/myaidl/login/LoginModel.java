package com.example.myaidl.login;

import com.example.myaidl.base.BaseModel;

import rx.Observable;
import rx.Subscriber;

public class LoginModel extends BaseModel<LoginPresenter,ILoginContract.LoginModel> {
    public LoginModel(LoginPresenter mPresenter) {
        super(mPresenter);
    }

    @Override
    public ILoginContract.LoginModel getContract() {
        return new ILoginContract.LoginModel() {
            @Override
            public void requestLogin(String name, String pwd) {

                loadDataFromServer(name,pwd);
            }
        };
    }


    private void loadDataFromServer(final String name,final String pwd){
        if(name.equals("abc")&& pwd.equals("123")){
            mPresenter.getContract().requestLoginResult(true);
        }else{
            mPresenter.getContract().requestLoginResult(false);
        }


    }
}
