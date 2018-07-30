package com.gdqt.mymvptest.ui.realdata.detail;

import com.gdqt.mymvptest.entity.RealDataDetailEvent;
import com.gdqt.mymvptest.ui.base.IBasePresenter;

public interface IRealDataDetailPresenter<V extends  IRealDataDetailView> extends IBasePresenter<V> {
    void  onSetTitle(RealDataDetailEvent event);
    void  onshowDetail(RealDataDetailEvent event);
}
