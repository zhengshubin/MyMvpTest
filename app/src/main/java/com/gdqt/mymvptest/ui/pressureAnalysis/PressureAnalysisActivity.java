package com.gdqt.mymvptest.ui.pressureAnalysis;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.gdqt.mymvptest.R;
import com.gdqt.mymvptest.ui.base.BaseActivity;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PressureAnalysisActivity extends BaseActivity  {

    @BindView(R.id.tab_pressureAnalysis)
    SmartTabLayout mSmartTabLayout;
    @BindView(R.id.vp_pressureAnalysis)
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentViewWithNetwork(R.id.ll_pressureAnalysis, R.layout.activity_pressure_analysis,"压力分析",true);


    }
}
