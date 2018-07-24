package com.gdqt.mymvptest.ui.realdata;

import com.gdqt.mymvptest.ui.base.IBasePresenter;

import java.util.Map;

public interface IRealDataPresenter<V extends IRealDataView> extends IBasePresenter<V> {
    void onShowRealData(Map<String,String> map);
}
