package com.example.myapplication.login;

/**
 * @author zhuojianhai
 * time 2020/12/29 11:57
 * 维护者
 */

public interface ILogin {
    interface LoginVP{
        void login(String name,String password);
        void loginResult(boolean result);
    }
    interface LoginM{
        void login(String name,String password);
    }
}