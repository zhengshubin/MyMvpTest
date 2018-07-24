package com.gdqt.mymvptest.ui.login;

import com.gdqt.mymvptest.ui.base.IBaseModel;
import com.gdqt.mymvptest.entity.LoginSPInfo;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;

import io.reactivex.Observable;
import io.reactivex.Observer;

public interface ILoginModel extends IBaseModel {
    Observable login(String  username, String password, Observer observer, LifecycleProvider<ActivityEvent> provider);
    LoginSPInfo getDataFromSP();
    void  setDataToSP(String username,String password);
    void  logout();
}
