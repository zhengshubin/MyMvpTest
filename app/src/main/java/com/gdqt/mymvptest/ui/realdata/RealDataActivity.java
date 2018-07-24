package com.gdqt.mymvptest.ui.realdata;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.cundong.recyclerview.EndlessRecyclerOnScrollListener;
import com.cundong.recyclerview.HeaderAndFooterRecyclerViewAdapter;
import com.gdqt.mymvptest.R;
import com.gdqt.mymvptest.common.MyAdapter;
import com.gdqt.mymvptest.ui.base.BaseActivity;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
public class RealDataActivity extends BaseActivity implements IRealDataView {
  private  RealDataPresenter  mPresenter=null;
  private HashMap<String,Object>param=new HashMap<>();
  private HeaderAndFooterRecyclerViewAdapter mHeaderAndFooterRecyclerViewAdapter=null;
    @BindView(R.id.rv_realData)
    RecyclerView rvRealData;
    @BindView(R.id.refresh_realData)
    SwipeRefreshLayout refreshRealData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real_data,"实时监测",true);
        mPresenter=new RealDataPresenter(this);
        initPresenter(mPresenter);
        initMap();
        initView();




    }
    void initView(){
        mPresenter.onShowRealData(param);

    }
    void  initMap(){
        param.put("COMPANY_ID", 1+"" );
        param.put("sidx", "F.ID");
        param.put("sord", "DESC");
        param.put("rows", 1000 + "");
        param.put("page", 1 + "");
    }

    @Override
    public void showRecyclerView(List<Map<String,Object>> list) {
        MyAdapter adapter=new MyAdapter(list);
        mHeaderAndFooterRecyclerViewAdapter=new HeaderAndFooterRecyclerViewAdapter(adapter);

        rvRealData.setLayoutManager(new LinearLayoutManager(this));
rvRealData.addOnScrollListener(mOnScrollListener);
        rvRealData.setAdapter(adapter);

    }
    private EndlessRecyclerOnScrollListener mOnScrollListener = new EndlessRecyclerOnScrollListener(){

    };
}
