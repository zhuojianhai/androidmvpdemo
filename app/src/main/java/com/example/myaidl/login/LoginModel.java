package com.example.myaidl.login;

import com.example.myaidl.base.BaseModel;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

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


        Observable.create(new ObservableOnSubscribe<String>() {

            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {

                //这里面模拟真正的网络请求
                if(name.equals("abc")&& pwd.equals("123")){
                    emitter.onNext("true");

                }else{
                    emitter.onNext("false");

                }


            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {
                if(s.equals("true")){
                    mPresenter.getContract().requestLoginResult(true);
                }else{
                    mPresenter.getContract().requestLoginResult(false);
                }

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {


            }
        });

    }
}
