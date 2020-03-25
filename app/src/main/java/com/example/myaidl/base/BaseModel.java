package com.example.myaidl.base;




public  abstract  class BaseModel<P extends BasePresenter,CONTRACT> extends SuperBase<CONTRACT> {
    public P mPresenter;
    public BaseModel(P mPresenter){
        this.mPresenter = mPresenter;
    }


//    protected <T> void addActivitySubscribe(BaseActivity context, Observable<T> observable, Subscriber<T> subscriber ) {
//         observable.subscribeOn(Schedulers.io())
//        .observeOn(AndroidSchedulers.mainThread())
//        .compose(context.<T>bindUntilEvent(ActivityEvent.DESTROY))//绑定生命周期，防止内存泄露
//         .subscribe(subscriber);
// }



//    protected  <T> void addFragmentSubscribe(Context context,Observable<T> observable,Subscriber<T> subscriber ) {
//        observable.subscribeOn(Schedulers.io())
//         .observeOn(AndroidSchedulers.mainThread())
//        .compose(context.<T>bindUntilEvent(FragmentEvent.DESTROY))//绑定生命周期，防止内存泄露
//         .subscribe(subscriber);
// }

}
