package com.gdqt.mymvptest.ui.login;

import com.gdqt.mymvptest.ApiService.LoginApi;
import com.gdqt.mymvptest.ui.base.BaseModel;
import com.gdqt.mymvptest.common.CustomFunction;
import com.gdqt.mymvptest.entity.AppData;
import com.gdqt.mymvptest.entity.LoginSPInfo;
import com.gdqt.mymvptest.utils.SPUtils;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;

import io.reactivex.Observable;
import io.reactivex.Observer;

public class LoginModel extends BaseModel implements ILoginModel {


    private  LoginApi loginApi=createRetrofit().create(LoginApi.class);
    @Override
    public Observable  login(String username, String password , Observer observer, LifecycleProvider<ActivityEvent> provider){
     Observable  observable=loginApi.login(username,password).map(new CustomFunction.ResultDataFunc<AppData>());
     toSubscribe(observable,observer,provider);
     return  observable;


    }

    @Override
    public LoginSPInfo getDataFromSP() {
        return SPUtils.LoginSP.getLoginData();
    }

    @Override
    public void setDataToSP(String username, String password) {
        LoginSPInfo info=new LoginSPInfo();
        info.setLogined(true);
        info.setUsername(username);
        info.setPassword(password);
        SPUtils.LoginSP.setLoginData(info);
    }


    @Override
    public void logout() {

    }
}
