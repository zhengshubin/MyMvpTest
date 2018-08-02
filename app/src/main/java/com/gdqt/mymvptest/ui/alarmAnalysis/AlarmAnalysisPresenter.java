package com.gdqt.mymvptest.ui.alarmAnalysis;

import android.util.Log;

import com.gdqt.mymvptest.common.MyObserver;
import com.gdqt.mymvptest.common.ValueCallBack;
import com.gdqt.mymvptest.entity.AppData;
import com.gdqt.mymvptest.ui.base.BasePresenter;
import com.gdqt.mymvptest.utils.FormatUtils;
import com.gdqt.mymvptest.utils.LogUtils;
import com.gdqt.mymvptest.utils.NetworkUtils;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.disposables.Disposable;

public class AlarmAnalysisPresenter<V extends  IAlarmAnalysisView> extends BasePresenter<V> implements IAlarmAnalysisPresenter<V> {
    private  AlarmAnalysisModel  mModel=null;
    public AlarmAnalysisPresenter(LifecycleProvider<ActivityEvent> provider) {
        super(provider);
        mModel=new AlarmAnalysisModel();

    }

    @Override
    public void onFirstLoadingData(final int viewType, Map<String, String> param) {
        if (!NetworkUtils.isNetworkConnected()){
            getView().netDisconnect();
            return;
        }
        getView().showLoading();
        MyObserver  observer=new MyObserver(new ValueCallBack<AppData<Map<String,Object>>>() {

            @Override
            public void onSubscribe(Disposable d) {
                setDisposable(d);

            }

            @Override
            public void onNext(AppData<Map<String, Object>> appData) {
                getView().hideLoading();
                if (!isViewAttached()){
                    return;
                }
                List<Map<String,Object>> list=new ArrayList<>();

                Map<String,Object> map=new HashMap<>();
                map.put("FFM_NAME","站点名称");
                if (viewType==AlarmAnalysisActivity.ALARMTOP){
                map.put("PRESSURE_LIMIT","压力上限值");
                }else {
                map.put("PRESSURE_LIMIT","压力下限值");
                }
                map.put("PRESSURE_ALARM","告警压力值");
                map.put("REASON","告警原因");
                map.put("CREATE_DATE","采集时间");
                list.add(map);
                for (Map<String,Object> map1:appData.getList()){
                    list.add(format(map1,viewType));
                }
                LogUtils.d("DDF",list.get(0).toString());
                getView().showFirstRecyclerView(list,Integer.parseInt(appData.getTotal()));




            }

            @Override
            public void onError(Throwable e) {
                getView().onError(e.getMessage());

            }

            @Override
            public void onComplete() {

            }
        });
        mModel.getAlarmData(param,viewType,observer,getProvider());

    }

    @Override
    public void onRefreshData(final int viewType, Map<String, String> param) {
        if (!NetworkUtils.isNetworkConnected()){
            getView().setRefreshState(false);
            return;
        }

        MyObserver observer=new MyObserver(new ValueCallBack<AppData<Map<String,Object>>>() {
            @Override
            public void onSubscribe(Disposable d) {
                setDisposable(d);
            }

            @Override
            public void onNext(AppData<Map<String, Object>> appData) {
                if (!isViewAttached()){
                    return;
                }
                getView().setRefreshState(true);
                List<Map<String,Object>> list=new ArrayList<>();

                Map<String,Object> map=new HashMap<>();
                map.put("FFM_NAME","站点名称");
                if (viewType==AlarmAnalysisActivity.ALARMTOP){
                    map.put("PRESSURE_LIMIT","压力上限值");
                }else {
                    map.put("PRESSURE_LIMIT","压力下限值");
                }
                map.put("PRESSURE_ALARM","告警压力值");
                map.put("REASON","告警原因");
                map.put("CREATE_DATE","采集时间");
                list.add(map);
                for (Map<String,Object> map1:appData.getList()){
                    list.add(format(map1,viewType));
                }
                getView().refreshRecyclerView(list);


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
    public void onFooterLoadingData(final int viewType, Map<String, String> param) {
        if (!NetworkUtils.isNetworkConnected()) {
            new Thread() {

                @Override
                public void run() {


                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    getView().footerNetworkError();
                    return;


                }
            }.start();
        }

        MyObserver myObserver=new MyObserver(new ValueCallBack<AppData<Map<String,Object>>>() {


            @Override
            public void onSubscribe(Disposable d) {
                setDisposable(d);

            }

            @Override
            public void onNext(AppData<Map<String, Object>> appData) {
                List<Map<String,Object>> list=new ArrayList<>();
                for (Map<String,Object> map:appData.getList()){
                    list.add(format(map,viewType));
                }
                getView().footerLoading(list);



            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

    }

    @Override
    public void onLoadingDataWithChoice(int viewType, Map<String, String> param) {

    }

    Map<String,Object> format(Map<String,Object> map,int viewType){
        long time=(long) Double.parseDouble(map.get("CREATE_DATE").toString());
        if (viewType==AlarmAnalysisActivity.ALARMTOP){
        map.put("PRESSURE_LIMIT",map.get("PRESSURE_TOPLIMIT"));
        }else if (viewType==AlarmAnalysisActivity.ALARMLOWER){
            map.put("PRESSURE_LIMIT",map.get("PRESSURE_LOWERLIMIT"));
        }

        String FREEZE_DATE= FormatUtils.DateFormat(time);
        Log.d("AlarmAnalysisPresenter", "format: "+FREEZE_DATE);
        map.put("CREATE_DATE",FREEZE_DATE);
        return map;

    }


}
