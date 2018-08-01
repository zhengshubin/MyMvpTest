package com.gdqt.mymvptest.ui.alarmAnalysis;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

import com.gdqt.mymvptest.HeadAndFooterRecyclerView.HeaderAndFooterRecyclerViewAdapter;
import com.gdqt.mymvptest.R;
import com.gdqt.mymvptest.common.NetworkRefreshListener;
import com.gdqt.mymvptest.ui.base.BaseActivity;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.ViewPagerItem;
import com.ogaclejapan.smarttablayout.utils.ViewPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.ViewPagerItems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

public class AlarmAnalysisActivity extends BaseActivity implements IAlarmAnalysisView {
    /**
     * 上限
     */
    public static final int ALARMTOP = 0;
    /**
     * 下限
     */
    public static final int ALARMLOWER = 1;
    private static final int REQUEST_ROWS = 11;
    @BindView(R.id.tab_alarmAnalysis)
    SmartTabLayout mSmartTabLayout;
    @BindView(R.id.vp_alarmAnalysis)
    ViewPager mViewPager;
    /**
     * 总页数
     */
    private int mTotal = 0;
    private static final String TAG = "AlarmAnalysisActivity";
    /**
     * 服务器端一共多少条数据
     */
    private int mTotalCounter = 0;

    /**
     * 每一页展示多少条数据
     */
    private static final int REQUEST_COUNT = 11;

    /**
     * 已经获取到多少条数据了
     */
    private int mCurrentCounter = 0;
    /**
     * 当前页
     */
    private int mCurrentPage = 1;
    private String FFM_NAME = "";
    private String COMPANY_ID = "";
    private List<Map<String, Object>> mList = new ArrayList<>();
    private HeaderAndFooterRecyclerViewAdapter mHeaderAndFooterRecyclerViewAdapter = null;
    private AlarmAnalysisPresenter mPresenter = null;
    private HashMap<String, String> param = new HashMap<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentViewWithNetwork(R.id.ll_alarmAnalysis, R.layout.activity_alarm_analysis, "压力告警", true);
//        mPresenter = new AlarmAnalysisPresenter(this);
//        initPresenter(mPresenter);
        initView();


    }

    public void initView() {
        final ViewPagerItemAdapter adapter = new ViewPagerItemAdapter(ViewPagerItems.with(this)
                .add(R.string.title, R.layout.activity_login)
                .add("登陆", R.layout.activity_login)
                .create());
        mViewPager.setAdapter(adapter);

        mSmartTabLayout.setViewPager(mViewPager);
        mSmartTabLayout.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {





            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
//        initMap();
//        mPresenter.onFirstLodingData(ALARMTOP, param);
    }

    void initMap() {
        param.clear();
        param.put("COMPANY_ID", COMPANY_ID);
        param.put("sidx", "F.ID");
        param.put("sord", "DESC");
        param.put("rows", REQUEST_COUNT + "");
        param.put("page", mCurrentPage + "");
        param.put("FFM_NAME", FFM_NAME);

    }

    @Override
    public void showFirstRecyclerView(List<Map<String, Object>> list,int total) {


    }


    @Override
    public void footerLoding(List<Map<String, Object>> list) {

    }

    @Override
    public void loaingWithFFM_Name(List<Map<String, Object>> list) {

    }
}
