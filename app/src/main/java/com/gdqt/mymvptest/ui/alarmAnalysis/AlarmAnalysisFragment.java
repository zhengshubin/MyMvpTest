package com.gdqt.mymvptest.ui.alarmAnalysis;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.gdqt.mymvptest.HeadAndFooterRecyclerView.EndlessRecyclerOnScrollListener;
import com.gdqt.mymvptest.HeadAndFooterRecyclerView.HeaderAndFooterRecyclerViewAdapter;
import com.gdqt.mymvptest.R;
import com.gdqt.mymvptest.adapter.AlarmAnalysisAdapter;
import com.gdqt.mymvptest.common.LoadingFooter;
import com.gdqt.mymvptest.ui.base.BaseFragment;
import com.gdqt.mymvptest.utils.DisklrucacheUtils;
import com.gdqt.mymvptest.utils.NetworkUtils;
import com.gdqt.mymvptest.utils.RecyclerViewStateUtils;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class AlarmAnalysisFragment extends BaseFragment implements IAlarmAnalysisView {
    @BindView(R.id.rv_alarmAnalysis)
    RecyclerView mRecyclerView;
    @BindView(R.id.aa_refreshLayout)
    SmartRefreshLayout mRefreshLayout;
    @BindView(R.id.tv_aa_FFM_NAME)
    TextView tv_FFM_NAME;
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
    private List FFM_NAMES = DisklrucacheUtils.getFFMNames();
    private String COMPANY_ID = DisklrucacheUtils.getCompanyID();
    private List<Map<String, Object>> mList = new ArrayList<>();
    private AlarmAnalysisAdapter mAdapter = null;
    private HeaderAndFooterRecyclerViewAdapter mHeaderAndFooterRecyclerViewAdapter = null;
    private AlarmAnalysisPresenter mPresenter = null;
    private HashMap<String, String> param = new HashMap<>();
    private int position = 0;


    public AlarmAnalysisFragment() throws IOException {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new AlarmAnalysisPresenter(getBaseActivity());
        initPresenter(mPresenter);
        setLayoutID(R.layout.fragment_alarm_analysis);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        position = FragmentPagerItem.getPosition(getArguments());
        Log.d(TAG, "onCreateView: " + position);
        return super.onCreateView(inflater, container, savedInstanceState);
    }


    @Override
    public void initView() {
        tv_FFM_NAME.setText(FFM_NAMES.get(0).toString());
        tv_FFM_NAME.setOnClickListener(mEditTextClick);
        initMap();
        mPresenter.onFirstLoadingData(position, param);
        mRefreshLayout.setEnableLoadMore(false);
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                if (NetworkUtils.isNetworkConnected()) {
                    initRefreshData();
                }
                mPresenter.onRefreshData(position,param);
            }
        });



    }

    @Override
    public void showFirstRecyclerView(List<Map<String, Object>> list, int total) {
        mTotal = total;
        mTotalCounter = mTotal * REQUEST_COUNT;
        mList.clear();
        addItems(list);
        mCurrentCounter += mList.size();
        //解决当进入页面时取消加载，此时onNext事件执行不了即showRecyclerView执行不了，mAdapter为空。
        if (mAdapter == null) {
            mAdapter = new AlarmAnalysisAdapter(mList);
            mHeaderAndFooterRecyclerViewAdapter = new HeaderAndFooterRecyclerViewAdapter(mAdapter);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(getBaseActivity()));
            mRecyclerView.addOnScrollListener(mOnScrollListener);
            mRecyclerView.setAdapter(mHeaderAndFooterRecyclerViewAdapter);
        }else {
            mHeaderAndFooterRecyclerViewAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void refreshRecyclerView(List<Map<String, Object>> list) {
        mList.clear();
        addItems(list);
        mCurrentCounter += mList.size();
        mHeaderAndFooterRecyclerViewAdapter.notifyDataSetChanged();


    }

    @Override
    public void footerLoading(List<Map<String, Object>> list) {
        addItems(list);
        //当在最后一页时，调整数据总量
        if (mCurrentPage == mTotal) {
            mTotalCounter = (mTotal - 1) * REQUEST_COUNT + list.size();
        }
        mCurrentCounter = mList.size();
        RecyclerViewStateUtils.setFooterViewState(mRecyclerView, LoadingFooter.State.Normal);


    }

    @Override
    public void loadingWithFFM_Name(List<Map<String, Object>> list) {

    }

    @Override
    public void setRefreshState(boolean isSuccess) {
        if (mRefreshLayout!=null){
            mRefreshLayout.finishRefresh(isSuccess);
        }

    }

    @Override
    public void footerNetworkError() {
        getBaseActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                RecyclerViewStateUtils
                        .setFooterViewState(getBaseActivity(), mRecyclerView, REQUEST_COUNT, LoadingFooter.State.NetWorkError, mFooterClick);
            }
        });

    }

    //下滑分页加载监听事件
    private EndlessRecyclerOnScrollListener mOnScrollListener = new EndlessRecyclerOnScrollListener() {
        @Override
        public void onLoadNextPage(View view) {
            super.onLoadNextPage(view);
            LoadingFooter.State state = RecyclerViewStateUtils.getFooterViewState(mRecyclerView);
            if (state == LoadingFooter.State.Loading) {

                return;
            }

            if (mCurrentCounter < mTotalCounter) {

                // loading more
                RecyclerViewStateUtils
                        .setFooterViewState(getBaseActivity(), mRecyclerView, REQUEST_COUNT, LoadingFooter.State.Loading, null);
                //判断是否有网络，如果没有网络则不需要更改数据
                if (NetworkUtils.isNetworkConnected()) {
                    mCurrentPage += 1;
                    setAskPage(mCurrentPage);
                    Log.d(TAG, "onLoadNextPage: " + COMPANY_ID);
                }
                mPresenter.onFooterLoadingData(position, param);


            } else {
                //the end
                RecyclerViewStateUtils
                        .setFooterViewState(getBaseActivity(), mRecyclerView, REQUEST_COUNT, LoadingFooter.State.TheEnd, null);
            }
        }


    };
    //当网络错误重新点击或加载
    private View.OnClickListener mFooterClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RecyclerViewStateUtils
                    .setFooterViewState(getBaseActivity(), mRecyclerView, REQUEST_COUNT, LoadingFooter.State.Loading, null);
            Log.d(TAG, "onClick: " + param.toString());
            //当有网的时候页面才去加一
            if (NetworkUtils.isNetworkConnected()) {
                mCurrentPage += 1;
                setAskPage(mCurrentPage);
            }
            mPresenter.onFooterLoadingData(position, param);

        }

    };
    private View.OnClickListener mEditTextClick=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //设置 选项器    https://github.com/Bigkoo/Android-PickerView
            OptionsPickerView pvOptions = new OptionsPickerBuilder(getBaseActivity(), new OnOptionsSelectListener() {
                @Override
                public void onOptionsSelect(int options1, int option2, int options3 ,View v) {
                    //返回的分别是三个级别的选中位置
                    tv_FFM_NAME.setText(FFM_NAMES.get(options1).toString());
                    initRefreshData();
                    mPresenter.onFirstLoadingData(position,param);

                }
            }).build();

            pvOptions.setPicker(FFM_NAMES);
            pvOptions.show();
        }
    };

    void initMap() {
        param.clear();
        param.put("COMPANY_ID", COMPANY_ID);
        param.put("sidx", "F.ID");
        param.put("sord", "DESC");
        param.put("rows", REQUEST_COUNT + "");
        param.put("page", mCurrentPage + "");
        String FFM_NAME=tv_FFM_NAME.getText().toString();
        if (FFM_NAME.equals("所有站点")){
            FFM_NAME="";
        }
        param.put("FFM_NAME", FFM_NAME);

    }
    //初始化刷新后的数据
    void initRefreshData() {
        mCurrentPage = 1;
        mCurrentCounter = 0;
        mTotalCounter = 0;
        mTotal = 0;
        initMap();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }

    void addItems(List<Map<String, Object>> list) {
        for (Map<String, Object> map : list) {
            mList.add(map);
        }
    }

    /**
     * 设置要获取数据的页面
     */
    void setAskPage(int page) {
        param.put("page", page + "");
    }
}
