package com.gdqt.mymvptest.ui.main;

import com.gdqt.mymvptest.entity.UserInfoEvent;
import com.gdqt.mymvptest.ui.base.IBaseModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IMainModel<T>extends IBaseModel {
    Map<String,Object> getUserInfo();
    ArrayList<HashMap<String, Object>> getGridViewData();
    UserInfoEvent setUserInfoEvent(Map<String,Object> map);
}
