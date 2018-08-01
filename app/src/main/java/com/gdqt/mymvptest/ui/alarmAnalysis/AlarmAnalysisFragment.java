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

import com.gdqt.mymvptest.HeadAndFooterRecyclerView.EndlessRecyclerOnScrollListener;
import com.gdqt.mymvptest.HeadAndFooterRecyclerView.HeaderAndFooterRecyclerViewAdapter;
import com.gdqt.mymvptest.R;
import com.gdqt.mymvptest.adapter.AlarmAnalysisAdapter;
import com.gdqt.mymvptest.common.LoadingFooter;
import com.gdqt.mymvptest.ui.base.BaseFragment;
import com.gdqt.mymvptest.ui.realdata.RealDataActivity;
import com.gdqt.mymvptest.utils.NetworkUtils;
import com.gdqt.mymvptest.utils.RecyclerViewStateUtils;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;

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
    Unbinder unbinder;
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
    private AlarmAnalysisAdapter mAdapter=null;
    private HeaderAndFooterRecyclerViewAdapter mHeaderAndFooterRecyclerViewAdapter = null;
    private AlarmAnalysisPresenter mPresenter = null;
    private HashMap<String, String> param = new HashMap<>();
    private int position = 0;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setLaoutID(R.layout.fragment_alarm_analysis);
        position = FragmentPagerItem.getPosition(getArguments());
        unbinder = ButterKnife
                .bind(this, super.onCreateView(inflater, container, savedInstanceState));
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter = new AlarmAnalysisPresenter(getBaseActivity());
        initPresenter(mPresenter);
    }

    @Override
    public void initView() {
        initMap();
        mPresenter.onFirstLodingData(position, param);


    }

    @Override
    public void showFirstRecyclerView(List<Map<String, Object>> list,int total) {
        mTotal = total;
        mTotalCounter = mTotal * REQUEST_COUNT;
        mList.clear();
        addItems(list);
        mCurrentCounter += mList.size();
        //解决当进入页面时取消加载，此时onNext事件执行不了即showRecyclerView执行不了，mAdapter为空。
        if ( mAdapter == null) {
            mAdapter = new AlarmAnalysisAdapter(mList);
            mHeaderAndFooterRecyclerViewAdapter = new HeaderAndFooterRecyclerViewAdapter(mAdapter);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(getBaseActivity()));
            mRecyclerView.addOnScrollListener(mOnScrollListener);
            mRecyclerView.setAdapter(mHeaderAndFooterRecyclerViewAdapter);
        }
    }

    @Override
    public void footerLoding(List<Map<String, Object>> list) {

    }

    @Override
    public void loaingWithFFM_Name(List<Map<String, Object>> list) {

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
                mPresenter.onFooterLodingData(position,param);
            } else {
                //the end
                RecyclerViewStateUtils
                        .setFooterViewState(getBaseActivity(), mRecyclerView, REQUEST_COUNT, LoadingFooter.State.TheEnd, null);
            }
        }


    };

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
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
    void  addItems(List<Map<String,Object>>  list){
        for (Map<String,Object> map:list){
            mList.add(map);
        }
    }
    /**

     设置要获取数据的页面
     */
    void setAskPage(int page){
        param.put("page",page+"");
    }
}
