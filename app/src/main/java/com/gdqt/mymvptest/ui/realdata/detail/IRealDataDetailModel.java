package com.gdqt.mymvptest.ui.realdata.detail;

import com.gdqt.mymvptest.entity.RealDataDetailEvent;
import com.gdqt.mymvptest.ui.base.IBaseModel;

import java.util.List;

public interface IRealDataDetailModel extends IBaseModel {
    String  getTitle(RealDataDetailEvent event);
    List getList(RealDataDetailEvent event);
}
