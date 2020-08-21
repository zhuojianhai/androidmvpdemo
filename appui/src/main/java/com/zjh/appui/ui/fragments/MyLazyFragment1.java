package com.zjh.appui.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trello.rxlifecycle3.components.RxFragment;

public abstract  class MyLazyFragment1 extends RxFragment {

    //接收fragment 布局view的变量
    protected View rootView = null;
    //view 是否已经创建
    boolean isViewCreated = false;

    private boolean isFirstVisible = true;//是否第一次可见
    /**
     * 为了获得 Fragment 不可见的状态，和再次回到可见状态的判断，
     * 我们还需要增加一个 currentVisibleState 标志位，
     * 该标志位在 onResume 中和 onPause 中结合 getUserVisibleHint 的返回值
     * 来决定是否应该回调可见和不可见状态函数
     * 当前fragment 可见、不可见标示
     */
    private boolean currentVisibleState = false;

    public MyLazyFragment1() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (rootView == null){
                rootView = inflater.inflate(layoutResid(),container,false);
        }
        initView(rootView);
        isViewCreated = true;

        if (!isHidden() && getUserVisibleHint()){
            dispatchUserVisibleHint(true);
        }
        return rootView;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isViewCreated){
            if (isVisibleToUser && !currentVisibleState){
                dispatchUserVisibleHint(true);
            }else if (!isVisibleToUser && currentVisibleState){
                dispatchUserVisibleHint(false);
            }
        }
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden){
            dispatchUserVisibleHint(false);
        }else {
            dispatchUserVisibleHint(true);
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        //只有非第一次从不可见到可见状态才处理
        if (!isFirstVisible){
            if (!isHidden() && !currentVisibleState && getUserVisibleHint()){
                dispatchUserVisibleHint(true);
            }
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (currentVisibleState && getUserVisibleHint()){
            dispatchUserVisibleHint(false);
        }
    }

    protected abstract  void initView(View rootView) ;

    protected abstract int layoutResid();

    /**
     * 统一处理用户可见信息分发
     * 分第一次可见，可见，不可见分发
     * @param isVisible   分发事件是否可见，isVisible = true是可见
     */
    private void dispatchUserVisibleHint(boolean isVisible){
        if (currentVisibleState == isVisible) {
            return;
        }

        currentVisibleState = isVisible;
        if (isVisible){
            if (isFirstVisible){
                isFirstVisible = false;
                onFragmentFirstVisible();
            }
            onFragmentVisible();
        }else{
            onFragmentInvisible();
        }

    }

    //当前fragmeng第一次可见，可做的业务操作
    protected abstract void onFragmentFirstVisible();
    //当前fragmeng非第一次可见，可做的业务操作
    protected abstract void onFragmentVisible();
    //当前fragment不可见
    protected abstract void onFragmentInvisible();

}
