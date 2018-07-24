package com.gdqt.mymvptest.common;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
/**
* author:zhengshubin
*create：2018/7/19
* description:该类为rxjava中的自定义观察者类,disposale要获取并及时关闭，防止内存泄漏
*/
public    class MyObserver<T> implements Observer<T> {
public   Disposable mDisposable;
    private  static  final  String TAG="MyObserver";
    private ValueCallBack  mcallBack;
    public  MyObserver(ValueCallBack  callBack){
        mcallBack=callBack;

    }
    @Override
    public void onSubscribe(Disposable d) {
        mcallBack.onSubscribe(d);

    }

    @Override
    public void onNext(T t) {
if (mcallBack!=null)
    mcallBack.onNext(t);
    }

    @Override
    public void onError(Throwable e) {
mcallBack.onError(e);
if (mDisposable!=null&&mDisposable.isDisposed())
    mDisposable.dispose();

    }

    @Override
    public void onComplete() {
mcallBack.onComplete();
        if (mDisposable!=null&&mDisposable.isDisposed())
            mDisposable.dispose();
    }

    public Disposable getDisposable() {
        return mDisposable;

    }


}
