package com.gdqt.mymvptest.ui.base;


import com.gdqt.mymvptest.common.RetrofitManager;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class BaseModel<T> implements IBaseModel<T> {

    public BaseModel() {

    }

    @Override
    public Retrofit createRetrofit() {
        RetrofitManager retrofitManager = RetrofitManager.getSingleton();
        Retrofit retrofit = retrofitManager.getRetrofit();
        return retrofit;


    }
/**
* author:zhengshubin
*create：2018/7/24
* description:
 * observable：lifecycleProvider:rxliferecycle   回收disposable  防止内存泄漏

*/
    @Override
    public void toSubscribe(Observable<T> observable, Observer<T> observer,LifecycleProvider<ActivityEvent> provider) {
                observable.subscribeOn(Schedulers.io()).compose(provider.<T>bindUntilEvent(ActivityEvent.STOP))
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}


