package com.gdqt.mymvptest.ui.main;

import com.gdqt.mymvptest.ui.base.IBaseModel;

import java.util.List;
import java.util.Map;

public interface IMainModel<T>extends IBaseModel {
    Map<String,Object> getUserInfo();
}
