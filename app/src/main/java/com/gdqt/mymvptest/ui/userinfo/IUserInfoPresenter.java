package com.gdqt.mymvptest.ui.userinfo;

import com.gdqt.mymvptest.entity.UserInfoEvent;
import com.gdqt.mymvptest.ui.base.IBasePresenter;

public interface IUserInfoPresenter<V extends IUserInfoView> extends IBasePresenter<V> {
    void onShow_userInfo(UserInfoEvent event);
}
