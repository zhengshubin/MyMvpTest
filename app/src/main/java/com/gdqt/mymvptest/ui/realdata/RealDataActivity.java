package com.gdqt.mymvptest.ui.realdata;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
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
    SwipeRefreshLayout refreshRealData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real_data);



    }

    @Override
    public void showRecycleView() {

    }
}
