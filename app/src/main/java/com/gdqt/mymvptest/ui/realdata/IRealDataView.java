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
    void setCompanyID(String companyID);
    void  setRefreshState(boolean isSuccess);
}
