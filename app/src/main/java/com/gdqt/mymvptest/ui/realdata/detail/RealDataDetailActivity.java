package com.gdqt.mymvptest.ui.realdata.detail;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.gdqt.mymvptest.R;
import com.gdqt.mymvptest.entity.RealDataDetailEvent;
import com.gdqt.mymvptest.ui.base.BaseActivity;
import com.gdqt.mymvptest.ui.realdata.RealDataPresenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RealDataDetailActivity extends BaseActivity implements  IRealDataDetailView{
private  String[] key=new String[]{"管道压力(MPa):","电池电压(V):","采集时间:","压力上限值(MPa):","压力下限值(MPa)"};
private String[] name_key=new String[]{"PIPE_PRESSURE","PIPE_VOLTAGE","FREEZE_DATE","PRESSURE_TOPLIMIT","PRESSURE_LOWERLIMIT"};
private List<Map<String,Object>> mList=new ArrayList<>();
private String title="";
private RealDataDetailPresenter  mPresenter=null;
    @BindView(R.id.lv_realData_detail)
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter=new RealDataDetailPresenter(this);
        initPresenter(mPresenter);
        EventBus.getDefault().register(this);

    }



    @Override
    protected void onStart() {

        super.onStart();

    }

    @Override
    protected void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();

    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
   public void onMessageEvent(RealDataDetailEvent event) {
        mPresenter.onSetTitle(event);
        mPresenter.onshowDetail(event);



}


    @Override
    public void showTitle(String title) {
        setContentView(R.layout.activity_real_data_detail,"实时监测-"+title,true);

    }

    @Override
    public void showDetail(List list) {
        mListView.setAdapter(new SimpleAdapter(this,list, R.layout.item_realdata_detail,new String[]{"key","value"},new int[]{R.id.tv_detail_item_key, R.id.tv_detail_item_value}));

    }
}
