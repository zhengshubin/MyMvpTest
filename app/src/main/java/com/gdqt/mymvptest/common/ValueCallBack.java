package com.gdqt.mymvptest.common;

import io.reactivex.disposables.Disposable;
/**
* author:zhengshubin
*create：2018/7/19
* description:该类用于
*/
public interface ValueCallBack<T> {
    void onSubscribe(Disposable d);
    void onNext(T t);
    void onError(Throwable e);
    void onComplete();
}
