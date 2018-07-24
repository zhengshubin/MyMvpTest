package com.gdqt.mymvptest.ui.base;

import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;

import io.reactivex.Observable;
import io.reactivex.Observer;
import retrofit2.Retrofit;

public interface IBaseModel<T> {
    Retrofit createRetrofit();
    void  toSubscribe(Observable<T> observable, Observer<T> observer, LifecycleProvider<ActivityEvent> provider);
}
