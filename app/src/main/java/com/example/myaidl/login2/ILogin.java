package com.example.myaidl.login2;

/**
 * 契约合同，
 * 降低耦合度
 */
public interface ILogin {

    public interface VP {
        //presenter的请求接口
        void requestLogin(String name, String pwd);
        //presenter  最后请求结果的回调接口
        void requestLoginResult(boolean loginResult);
    }

    public interface M{
        void requestLogin(String name, String pwd) throws Exception;
    }
}
