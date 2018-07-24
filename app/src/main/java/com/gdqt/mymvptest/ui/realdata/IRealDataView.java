package com.gdqt.mymvptest.ui.realdata;

import com.gdqt.mymvptest.ui.base.IBaseView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IRealDataView extends IBaseView {
    void  showRecyclerView(List<Map<String,Object>> list);
}
