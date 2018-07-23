package com.gdqt.mymvptest.ui.main;

import com.gdqt.mymvptest.R;
import com.gdqt.mymvptest.entity.UserInfoEvent;
import com.gdqt.mymvptest.ui.base.BaseModel;
import com.gdqt.mymvptest.utils.DisklrucacheUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainModel extends BaseModel implements IMainModel  {



    @Override
    public Map<String, Object> getUserInfo() {
        List<Map<String,Object>> list= DisklrucacheUtils.getLocalData();
        Map<String ,Object> map=(Map<String, Object>)list.get(0).get("userInfo");

        return map;
    }

    @Override
    public ArrayList<HashMap<String, Object>> getGridViewData() {
        ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> map1 = new HashMap<String, Object>();
        HashMap<String, Object> map2 = new HashMap<String, Object>();
        HashMap<String, Object> map3 = new HashMap<String, Object>();
        HashMap<String, Object> map4 = new HashMap<String, Object>();
        HashMap<String, Object> map5 = new HashMap<String, Object>();
        HashMap<String, Object> map6 = new HashMap<String, Object>();
        HashMap<String, Object> map7 = new HashMap<String, Object>();
        map1.put("image", R.drawable.icon_ssjk);
        map1.put("text", "实时监测");
        map2.put("image", R.drawable.icon_ylgj);
        map2.put("text", "压力报警");
        map3.put("image", R.drawable.icon_ylfx);
        map3.put("text", "压力曲线");
        map4.put("image", R.drawable.icon_sjcx);
        map4.put("text", "历史数据");
        map5.put("image", R.drawable.icon_dtzs);
        map5.put("text", "地图显示");
        map6.put("image", R.drawable.icon_grxx);
        map6.put("text", "个人信息");
        map7.put("image", R.drawable.icon_jqqd);
        map7.put("text", "敬请期待");
        list.add(map1);
        list.add(map2);
        list.add(map3);
        list.add(map4);
        list.add(map5);
        list.add(map6);
        list.add(map7);
        return list;
    }

    @Override
    public UserInfoEvent setUserInfoEvent(Map map) {
        UserInfoEvent  event=new UserInfoEvent();
        event.setMap(map);
        return event;
    }


}
