package com.gdqt.mymvptest.ui.userinfo;

import com.gdqt.mymvptest.entity.UserInfoEvent;
import com.gdqt.mymvptest.ui.base.IBaseView;

import java.util.Map;

public interface IUserInfoView extends IBaseView {
    void showUserInfo(Map<String,Object> map);
}
