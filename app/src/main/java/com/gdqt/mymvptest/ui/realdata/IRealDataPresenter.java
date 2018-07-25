package com.gdqt.mymvptest.ui.realdata;

import com.gdqt.mymvptest.ui.base.IBasePresenter;

import java.util.Map;

public interface IRealDataPresenter<V extends IRealDataView> extends IBasePresenter<V> {
    //展示第一页的数据
    void onFirstShowRealData(Map<String,String> map,boolean isRefresh);
    //分页展示剩下的数据
    void onPageShowRealData(Map<String,String>map);
}
