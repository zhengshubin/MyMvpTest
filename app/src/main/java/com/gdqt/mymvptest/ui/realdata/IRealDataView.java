package com.gdqt.mymvptest.ui.realdata;

import com.gdqt.mymvptest.ui.base.IBaseView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IRealDataView extends IBaseView {
    void  showRecyclerView(List<Map<String,Object>> list,int total);
    void notifyDataChange(List<Map<String,Object>> list);
    //下拉刷新时出现网络问题
    void  footerNetWorkError();
    /**
     设置刷新状态（true 刷新完成，false,刷新失败
    */
    void  setRefreshState(boolean isSuccess);
}
