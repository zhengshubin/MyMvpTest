package com.gdqt.mymvptest.ui.login;

import com.gdqt.mymvptest.ui.base.IBaseModel;
import com.gdqt.mymvptest.entity.LoginSPInfo;

import io.reactivex.Observable;

public interface ILoginModel<T> extends IBaseModel<T> {
    Observable<T> login(String  username, String password);
    LoginSPInfo getDataFromSP();
    void  setDataToSP(String username,String password);
    void  logout();
}
