package com.example.myaidl.login2;


import com.example.myaidl.base.BasePresenter;

/***
 * 子类创建对象的时候，执行构造方法，总是先执行父类的构造方法
 * 所以会执行父类的  this.mModel = getMoelInstance();代码
 *
 * 而当前类不是抽象类，必须实现 getMoelInstance()方法
 *
 *
 * 传递的是ILogin.VP接口，那么就要实现这个接口类型对象
 *
 * LoginActivity2 是当前类的View层
 */
public class LoginPresenter2 extends BasePresenter<LoginActivity2,LoginModel2, ILogin.VP> {


    @Override
    protected LoginModel2 getMoelInstance() {
        return new LoginModel2(this);
    }

    @Override
    public ILogin.VP getContract() {
        return new ILogin.VP() {
            @Override
            public void requestLogin(String name, String pwd) {

                try {
                    mModel.getContract().requestLogin(name,pwd);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void requestLoginResult(boolean loginResult) {
                mView.getContract().requestLoginResult(loginResult);

            }
        };
    }
}
