package com.gdqt.mymvptest.ui.alarmAnalysis;

import com.gdqt.mymvptest.ui.base.IBaseView;

import java.util.List;
import java.util.Map;

public interface IAlarmAnalysisView extends IBaseView {
    /**
    进入页面时展示数据
    */
    void showFirstRecyclerView(List<Map<String,Object>> list ,int total);

    /**
    * 向上滑动刷新数据
    */
    void  refreshRecyclerView(List<Map<String,Object>> list);
    /**
    * 向下加载
    */
    void  footerLoading(List<Map<String,Object>> list);
    /**
    * 选择站点名称加载数据
    */
    void   loadingWithFFM_Name(List<Map<String,Object>> list);
    /**
     * 设置刷新状态
     */
    void  setRefreshState(boolean isSuccess);
    /**
     * 向下加载时网络出现问题
     */
    void  footerNetworkError();


}
