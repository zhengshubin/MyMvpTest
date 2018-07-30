package com.gdqt.mymvptest.ui.realdata.detail;

import com.gdqt.mymvptest.ui.base.IBaseView;

import java.util.List;
import java.util.Map;

public interface IRealDataDetailView<T> extends IBaseView<T> {
    void  showTitle(String title);
    void  showDetail(List<Map<String,Object>> list);
}
