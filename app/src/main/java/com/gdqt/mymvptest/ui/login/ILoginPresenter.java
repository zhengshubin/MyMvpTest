package com.gdqt.mymvptest.ui.login;

import com.gdqt.mymvptest.ui.base.IBasePresenter;

public interface ILoginPresenter<V extends  ILoginView> extends IBasePresenter<V> {
    void  onLoginClick(String username,String password);
    void   saveLoginInfo(String username,String password);
    void   autoLogin();
}
