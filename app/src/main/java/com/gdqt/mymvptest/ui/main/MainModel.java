package com.gdqt.mymvptest.ui.main;

import com.gdqt.mymvptest.ui.base.BaseModel;
import com.gdqt.mymvptest.utils.DisklrucacheUtils;

import java.util.List;
import java.util.Map;

public class MainModel extends BaseModel implements IMainModel  {



    @Override
    public Map<String, Object> getUserInfo() {
        List<Map<String,Object>> list= DisklrucacheUtils.getLocalData();
        Map<String ,Object> map=(Map<String, Object>)list.get(0).get("userInfo");

        return map;
    }
}
