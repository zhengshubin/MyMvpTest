package com.gdqt.mymvptest.ui.main;

import com.gdqt.mymvptest.ui.base.IBasePresenter;

import java.util.Map;

import retrofit2.http.PUT;

public interface IMainPresenter<V extends IMainView> extends IBasePresenter<V> {
    public  void onNav_header();
    public  void  onGridView();
    void  onHeader_click(Map<String,Object> map);


}
