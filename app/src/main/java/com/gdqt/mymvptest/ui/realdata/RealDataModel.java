package com.gdqt.mymvptest.ui.realdata;

import android.util.Log;

import com.gdqt.mymvptest.ApiService.LoginApi;
import com.gdqt.mymvptest.ApiService.RealDataApi;
import com.gdqt.mymvptest.common.CustomFunction;
import com.gdqt.mymvptest.common.RetrofitManager;
import com.gdqt.mymvptest.entity.AppData;
import com.gdqt.mymvptest.ui.base.BaseModel;
import com.gdqt.mymvptest.utils.DisklrucacheUtils;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;

public class RealDataModel extends BaseModel implements IRealDataModel {
    private static String TAG="RealDataModel";
    private RealDataApi api = createRetrofit().create(RealDataApi.class);

    @Override
    public void getRealData(Map<String, String> map, Observer observer, LifecycleProvider<ActivityEvent> provider) {
        Observable observable = api
                .getRealData(map.get("DMA_NAME"), map.get("COMPANY_ID"), map.get("sidx"), map
                        .get("sord"), map.get("rows"), map.get("page"))
                .map(new CustomFunction.ResultDataFunc<AppData>());
        toSubscribe(observable, observer, provider);
    }

}