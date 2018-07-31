package com.gdqt.mymvptest.ui.alarmAnalysis;

import com.gdqt.mymvptest.ui.base.IBasePresenter;

import java.util.Map;

public interface IAlarmAnalysisPresenter<V extends  IAlarmAnalysisView> extends IBasePresenter<V> {
    void  onFirstLodingData(int viewType, Map<String,String> param);
    void  onFooterLodingData(int viewType,Map<String,String> param);
    void  onLodingDataWithChoice(int viewType,Map<String,String> param);
}
