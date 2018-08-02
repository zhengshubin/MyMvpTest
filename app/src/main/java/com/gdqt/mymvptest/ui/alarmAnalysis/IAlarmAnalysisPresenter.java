package com.gdqt.mymvptest.ui.alarmAnalysis;

import com.gdqt.mymvptest.ui.base.IBasePresenter;

import java.util.Map;

public interface IAlarmAnalysisPresenter<V extends  IAlarmAnalysisView> extends IBasePresenter<V> {
    void  onFirstLoadingData(int viewType, Map<String,String> param);
    void  onRefreshData(int viewType,Map<String,String> param);
    void  onFooterLoadingData(int viewType,Map<String,String> param);
    void  onLoadingDataWithChoice(int viewType,Map<String,String> param);
}
