package com.example.myaidl.login2;


import com.example.myaidl.base.BaseModel;

public class LoginModel2 extends BaseModel<LoginPresenter2,ILogin.M> {

    public LoginModel2(LoginPresenter2 mPresenter) {
        super(mPresenter);
    }

    @Override
    public ILogin.M getContract() {
        return new ILogin.M() {
            @Override
            public void requestLogin(String name, String pwd) throws Exception {
                //请求服务器登录接口，拿到接口数据，返回json数据

                if(name.equals("abc") && pwd.equals("123")){

//                    mPresenter.requestLoginResult(true);
                    mPresenter.getContract().requestLoginResult(true);
                }else{
//                    mPresenter.requestLoginResult(false);
                    mPresenter.getContract().requestLoginResult(false);
                }
            }
        };
    }
}
