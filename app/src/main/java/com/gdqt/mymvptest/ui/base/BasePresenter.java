package com.gdqt.mymvptest.ui.base;

import com.trello.rxlifecycle.android.ActivityEvent;
import com.trello.rxlifecycle2.LifecycleProvider;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;


import io.reactivex.disposables.Disposable;

public class BasePresenter<V extends IBaseView> implements IBasePresenter<V> {
    private LifecycleProvider<ActivityEvent> mProvider;
    private Disposable mDisposable;
    public LifecycleProvider<ActivityEvent> getProvider(){
        return  mProvider;
    }
    public V getView() {
        return mView.get();
    }
    //弱应用
    private Reference<V> mView;
private static final String TAG="BasePrensenter";
    public Disposable getDisposable() {
        return mDisposable;
    }

    public void setDisposable(Disposable mDisposable) {
        this.mDisposable = mDisposable;
    }



    public  BasePresenter(LifecycleProvider<ActivityEvent> provider){
        mProvider=provider;
    }
    @Override
    public void onAttach(V view) {
        if (view!=null)
       mView=new WeakReference<V>(view);
    }

    @Override
    public void onDetach() {
        if (mView!=null){
            mView.clear();
            mView=null;
        }




    }
    public  boolean isViewAttached(){
        return mView!=null&&mView.get()!=null;
    }
}
