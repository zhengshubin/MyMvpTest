package com.gdqt.mymvptest.ui.main;

import com.gdqt.mymvptest.ui.base.BasePresenter;
import com.gdqt.mymvptest.ui.base.IBaseView;
import com.trello.rxlifecycle2.LifecycleProvider;

import java.util.Map;

public class MainPresenter<V extends  IMainView> extends BasePresenter<V> implements IMainPresenter <V>{
    private  MainModel  mainModel=null;
    public MainPresenter(LifecycleProvider provider) {
        super(provider);
        mainModel=new MainModel();


    }

    @Override
    public void onNav_header() {
      getView().showNav_header(mainModel.getUserInfo());





    }

    @Override
    public void onGridView() {
        getView().initGridView(mainModel.getGridViewData());

    }

    @Override
    public void onHeader_click(Map<String,Object> map) {
        getView().OpenUserInfoActivity( mainModel.setUserInfoEvent(map));
    }
}
