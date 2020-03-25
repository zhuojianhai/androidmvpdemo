package com.example.myaidl.login;

public interface ILoginContract {

    public interface LoginView {
        void requestLoginResult(boolean result);
    }

    public interface LoginPresenter{
        void requestLogin(String name,String pwd);
        void requestLoginResult(boolean result);
    }

    public interface LoginModel{
        void requestLogin(String name,String pwd);
    }
}
