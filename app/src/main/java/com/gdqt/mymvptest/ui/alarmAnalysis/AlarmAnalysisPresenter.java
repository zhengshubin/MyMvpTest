package com.gdqt.mymvptest.ui.alarmAnalysis;

import com.gdqt.mymvptest.common.MyObserver;
import com.gdqt.mymvptest.common.ValueCallBack;
import com.gdqt.mymvptest.entity.AppData;
import com.gdqt.mymvptest.ui.base.BasePresenter;
import com.gdqt.mymvptest.utils.NetworkUtils;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;

import java.util.Map;

import io.reactivex.disposables.Disposable;

public class AlarmAnalysisPresenter<V extends  IAlarmAnalysisView> extends BasePresenter<V> implements IAlarmAnalysisPresenter<V> {
    private  AlarmAnalysisModel  mModel=null;
    public AlarmAnalysisPresenter(LifecycleProvider<ActivityEvent> provider) {
        super(provider);
        mModel=new AlarmAnalysisModel();

    }

    @Override
    public void onFirstLodingData(int viewType, Map<String, String> param) {
        if (!NetworkUtils.isNetworkConnected()){
            getView().netDisconnect();
            return;
        }
        getView().showLoding();
        MyObserver  observer=new MyObserver(new ValueCallBack<AppData<Map<String,Object>>>() {

            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(AppData<Map<String, Object>> appData) {
                getView().hideLoding();
                if (!isViewAttached()){
                    return;
                }




            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
        mModel.getAlarmData(param,viewType,observer,getProvider());

    }

    @Override
    public void onFooterLodingData(int viewType, Map<String, String> param) {

    }

    @Override
    public void onLodingDataWithChoice(int viewType, Map<String, String> param) {

    }


}
