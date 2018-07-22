package com.gdqt.mymvptest.ui.main;

import com.gdqt.mymvptest.ui.base.BasePresenter;
import com.gdqt.mymvptest.ui.base.IBaseView;
import com.squareup.haha.perflib.Main;
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
      Map<String,Object>  map= mainModel.getUserInfo();
      getView().showNav_header(map);




    }
}
