package com.gdqt.mymvptest.ui.base;


import com.gdqt.mymvptest.common.RetrofitManager;

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

    @Override
    public void toSubscribe(Observable<T> observable, Observer<T> observer) {
                observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}


