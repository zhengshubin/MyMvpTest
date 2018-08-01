package com.gdqt.mymvptest.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gdqt.mymvptest.R;
import com.gdqt.mymvptest.common.RetrofitManager;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public   class BaseFragment extends Fragment implements IBaseView{
    private volatile static BaseFragment baseFragment;
    private  BasePresenter mPresenter;
    private BaseActivity mActivity;
    private Unbinder mUnBinder;
    private  int layoutID;
    public  void  setLaoutID(int layoutID){
        this.layoutID=layoutID;
    }
    //无参的单例模式
    public static BaseFragment getSingleton() {
        if (baseFragment == null) {
            synchronized (BaseFragment.class) {
               baseFragment=new BaseFragment();
            }
        }
        return baseFragment;
    }
    public int getLayoutID(){return layoutID; };


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(getLayoutID(),container,false);
        setUnBinder(ButterKnife.bind(this,view));
        initView();
        return view;
    }

    public  void initView(){

    }

    public void initPresenter(BasePresenter  basePresenter){
        mPresenter=basePresenter;
        mPresenter.onAttach(this);

}
    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onDestroy() {
        if (mUnBinder!=null){
            mUnBinder.unbind();
            mPresenter.onDetach();

        }
        super.onDestroy();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity){
            BaseActivity activity= (BaseActivity) context;
            this.mActivity=activity;

        }
    }


    @Override
    public void showLoding() {
        if (mActivity!=null){
            mActivity.showLoding();
        }

    }

    @Override
    public void hideLoding() {
        if (mActivity!=null){
            mActivity.hideLoding();
        }

    }

    @Override
    public void onError(int resId) {
        if (mActivity!=null){
            mActivity.onError(resId);
        }

    }

    @Override
    public void onError(String message) {
        if (mActivity!=null){
            mActivity.onError(message);
        }
    }

    @Override
    public void netDisconnect() {
        if (mActivity!=null){
            mActivity.onError(R.string.connectException);
        }

    }
    public BaseActivity getBaseActivity() {
        return mActivity;
    }

    public void setUnBinder(Unbinder unBinder) {
        mUnBinder = unBinder;
    }

    @Override
    public void onDetach() {
        mActivity=null;
        super.onDetach();
    }
}
