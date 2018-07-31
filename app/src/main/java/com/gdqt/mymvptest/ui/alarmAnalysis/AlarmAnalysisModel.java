package com.gdqt.mymvptest.ui.alarmAnalysis;

import com.gdqt.mymvptest.ApiService.AlarmAnalysisApi;
import com.gdqt.mymvptest.common.CustomFunction;
import com.gdqt.mymvptest.common.RetrofitManager;
import com.gdqt.mymvptest.entity.AppData;
import com.gdqt.mymvptest.ui.base.BaseModel;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;

public class AlarmAnalysisModel<T> extends BaseModel<T> implements IAlarmAnalysisModel<T> {
    private AlarmAnalysisApi api= createRetrofit().create(AlarmAnalysisApi.class);


    @Override
    public void  getAlarmData(Map<String, String> map, int viewType, Observer observer, LifecycleProvider<ActivityEvent> provider) {
        Observable observable=null;
        if (viewType == AlarmAnalysisActivity.ALARMLOWER) {
            observable = api
                    .getAlarmLowerlimitData(map.get("COMPANY_ID"), map.get("sidx"), map
                            .get("sord"), map.get("rows"), map.get("page"), map.get("FFM_NAME")).map(new CustomFunction.ResultDataFunc<AppData>());

        }else if (viewType==AlarmAnalysisActivity.ALARMTOP){
            observable=api.getAlarmToplimitData(map.get("COMPANY_ID"), map.get("sidx"), map
                    .get("sord"), map.get("rows"), map.get("page"), map.get("FFM_NAME")).map(new CustomFunction.ResultDataFunc<AppData>());
        }
        toSubscribe(observable,observer,provider);

    }
}
