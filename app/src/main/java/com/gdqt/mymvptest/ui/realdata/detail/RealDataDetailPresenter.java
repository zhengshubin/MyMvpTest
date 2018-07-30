package com.gdqt.mymvptest.ui.realdata.detail;

import com.gdqt.mymvptest.entity.RealDataDetailEvent;
import com.gdqt.mymvptest.ui.base.BasePresenter;
import com.gdqt.mymvptest.ui.realdata.RealDataModel;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;

public class RealDataDetailPresenter<V extends  IRealDataDetailView> extends BasePresenter<V> implements IRealDataDetailPresenter<V> {
    private RealDataDetailModel  mModel=null;
    public RealDataDetailPresenter(LifecycleProvider<ActivityEvent> provider) {
        super(provider);
        mModel=new RealDataDetailModel();
    }

    @Override
    public void onSetTitle(RealDataDetailEvent event) {
        getView().showTitle(mModel.getTitle(event));

    }

    @Override
    public void onshowDetail(RealDataDetailEvent event) {
        getView().showDetail(mModel.getList(event));

    }
}
