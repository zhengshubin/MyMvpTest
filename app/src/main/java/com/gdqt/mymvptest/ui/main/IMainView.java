package com.gdqt.mymvptest.ui.main;

import com.gdqt.mymvptest.entity.UserInfoEvent;
import com.gdqt.mymvptest.ui.base.IBaseView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public interface IMainView extends IBaseView {
    void  showNav_header(Map<String,Object> map);
    void  initGridView(ArrayList<HashMap<String,Object>> list);
    void  OpenUserInfoActivity(UserInfoEvent event);

}
