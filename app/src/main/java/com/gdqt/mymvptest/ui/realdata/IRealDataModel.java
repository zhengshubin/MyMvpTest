package com.gdqt.mymvptest.ui.realdata;

import com.gdqt.mymvptest.ui.base.BaseModel;
import com.gdqt.mymvptest.ui.base.IBaseModel;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;

public interface IRealDataModel extends IBaseModel {
    public void getRealData(Map<String,String>map, Observer observer, LifecycleProvider<ActivityEvent> provider);



}
