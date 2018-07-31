package com.gdqt.mymvptest.ui.alarmAnalysis;

import com.gdqt.mymvptest.ui.base.IBaseModel;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;

public interface IAlarmAnalysisModel<T> extends IBaseModel<T> {
 public   void getAlarmData(Map<String,String> map,int viewType, Observer observer, LifecycleProvider<ActivityEvent> provider);

}
