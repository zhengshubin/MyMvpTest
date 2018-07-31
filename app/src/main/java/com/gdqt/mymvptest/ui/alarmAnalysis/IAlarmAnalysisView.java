package com.gdqt.mymvptest.ui.alarmAnalysis;

import com.gdqt.mymvptest.ui.base.IBaseView;

import java.util.List;
import java.util.Map;

public interface IAlarmAnalysisView extends IBaseView {
    /**
    进入页面时展示数据
    */
    void showFirstRecyclerView(List<Map<String,Object>> list);
    /**
    * 向下加载
    */
    void  footerLoding(List<Map<String,Object>> list);
    /**
    * 选择站点名称加载数据
    */
    void   loaingWithFFM_Name(List<Map<String,Object>> list);


}
