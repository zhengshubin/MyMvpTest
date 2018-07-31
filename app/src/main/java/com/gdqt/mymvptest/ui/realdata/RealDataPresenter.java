package com.gdqt.mymvptest.ui.realdata;

import android.nfc.Tag;
import android.text.TextUtils;
import android.util.Log;

import com.gdqt.mymvptest.common.MyObserver;
import com.gdqt.mymvptest.common.ValueCallBack;
import com.gdqt.mymvptest.entity.AppData;
import com.gdqt.mymvptest.entity.ResultData;
import com.gdqt.mymvptest.ui.base.BasePresenter;
import com.gdqt.mymvptest.utils.FormatUtils;
import com.gdqt.mymvptest.utils.LogUtils;
import com.gdqt.mymvptest.utils.NetworkUtils;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RealDataPresenter<V extends IRealDataView> extends BasePresenter<V> implements  IRealDataPresenter<V> {
    private  RealDataModel  mModel=null;
    private static final String TAG="RealDataPresenter";
    public RealDataPresenter(LifecycleProvider<ActivityEvent> provider) {
        super(provider);
        mModel=new RealDataModel();
    }

    @Override
    public void onFirstShowRealData(Map<String,String> map, final boolean isRefresh) {
        if (!NetworkUtils.isNetworkConnected()){
            getView().netDisconnect();
            if (isRefresh){
                getView().setRefreshState(false);
            }
            return;
        }
        //如果不是刷新类型就不需要打开加载画面
        if (!isRefresh) {
            getView().showLoding();
        }
        MyObserver observer = new MyObserver(new ValueCallBack<AppData<Map<String, Object>>>() {

            @Override
            public void onSubscribe(Disposable d) {
                setDisposable(d);

            }

            @Override
            public void onNext(AppData<Map<String, Object>> subjects) {
                if (!isViewAttached()){
                    return;
                }
                if (isRefresh) {
                    getView().setRefreshState(true);

                }else {
                    getView().hideLoding();
                }
                List<Map<String,Object>> list=new ArrayList<>();

                Map<String,Object> map=new HashMap<>();
                map.put("FFM_NAME","站点名称");
                map.put("PIPE_PRESSURE","压力值（MPa)");
                map.put("FREEZE_DATE","创建时间");
                list.add(map);
                for (Map<String,Object> map1:subjects.getList()){
                    list.add(format(map1));
                }
                LogUtils.d("DDF",list.get(0).toString());
                  getView().showRecyclerView(list,Integer.parseInt(subjects.getTotal()));


            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: "+e.getMessage());
                if (isRefresh){
                    getView().setRefreshState(false);
                }else {
                    Log.d(TAG, "onError: ");
                    getView().hideLoding();


                }
                getView().onError(e.getMessage());

            }

            @Override
            public void onComplete() {

            }

        });
        mModel.getRealData(map,observer,getProvider());
    }

    @Override
    public void onPageShowRealData(Map<String, String> map) {
        if (!NetworkUtils.isNetworkConnected()) {
            new Thread() {

                @Override
                public void run() {


                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    getView().footerNetWorkError();
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
                    list.add(format(map));
                }
                getView().notifyDataChange(appData.getList());



            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
        mModel.getRealData(map,myObserver,getProvider());


    }



    Map<String,Object> format(Map<String,Object> map){
       long time=(long) Double.parseDouble(map.get("FREEZE_DATE").toString());

            String FREEZE_DATE=FormatUtils.DateFormat(time);
       Log.d(TAG, "format: "+FREEZE_DATE);
            map.put("FREEZE_DATE",FREEZE_DATE);
        return map;

    }
}
