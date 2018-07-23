package com.gdqt.mymvptest.ui.realdata;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.gdqt.mymvptest.R;
import com.gdqt.mymvptest.ui.base.BaseActivity;
import com.yalantis.phoenix.PullToRefreshView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RealDataActivity extends BaseActivity implements IRealDataView {

    @BindView(R.id.rv_realData)
    RecyclerView rvRealData;
    @BindView(R.id.refresh_realData)
    PullToRefreshView refreshRealData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real_data);
      refreshRealData.setOnRefreshListener(new PullToRefreshView.OnRefreshListener() {
          @Override
          public void onRefresh() {
              refreshRealData.postDelayed(new Runnable() {
                  @Override
                  public void run() {
                      refreshRealData.setRefreshing(false);

                  }
              },4000);
          }
      });


    }

    @Override
    public void showRecycleView() {

    }
}
