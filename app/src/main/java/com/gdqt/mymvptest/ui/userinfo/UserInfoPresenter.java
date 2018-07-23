package com.gdqt.mymvptest.ui.userinfo;

import com.gdqt.mymvptest.entity.UserInfoEvent;
import com.gdqt.mymvptest.ui.base.BasePresenter;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;

public class UserInfoPresenter<V extends  IUserInfoView> extends BasePresenter<V> implements IUserInfoPresenter<V>{
    private  UserInfoModel  mModel=null;
    public UserInfoPresenter(LifecycleProvider<ActivityEvent> provider) {
        super(provider);
       mModel=new UserInfoModel();
    }

    @Override
    public void onShow_userInfo(UserInfoEvent event) {
        getView().showUserInfo(event.getMap());
    }
}
