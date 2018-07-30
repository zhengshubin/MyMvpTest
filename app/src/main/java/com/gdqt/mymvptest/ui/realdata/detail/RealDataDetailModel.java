package com.gdqt.mymvptest.ui.realdata.detail;

import com.gdqt.mymvptest.entity.RealDataDetailEvent;
import com.gdqt.mymvptest.ui.base.BaseModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RealDataDetailModel extends BaseModel implements IRealDataDetailModel {
    private  String[] key=new String[]{"管道压力(MPa):","电池电压(V):","采集时间:","压力上限值(MPa):","压力下限值(MPa)"};
    private String[] name_key=new String[]{"PIPE_PRESSURE","PIPE_VOLTAGE","FREEZE_DATE","PRESSURE_TOPLIMIT","PRESSURE_LOWERLIMIT"};
    @Override
    public String  getTitle(RealDataDetailEvent event) {
       return   event.getMap().get("FFM_NAME").toString();
    }

    @Override
    public List getList(RealDataDetailEvent event) {
        List<Map<String,Object>> list=new ArrayList<>();
        for (int i = 0; i < key.length;i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("key", key[i]);
            map.put("value", event.getMap().get(name_key[i]));
            list.add(map);
        }
        return list;
    }

}
