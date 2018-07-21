package com.gdqt.mymvptest.ui.base;

import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;

import io.reactivex.disposables.Disposable;

public class BasePresenter<V extends IBaseView> implements IBasePresenter<V> {
    public LifecycleProvider<ActivityEvent> mProvider;
    private Disposable mDisposable;
public V mView;
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
        mView =view;
    }

    @Override
    public void onDetach() {
        if (mView!=null){
            mView=null;
        }




    }
    public  boolean isViewAttached(){
        return mView!=null;
    }
}
