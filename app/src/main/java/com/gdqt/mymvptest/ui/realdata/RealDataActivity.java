package com.gdqt.mymvptest.ui.realdata;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.gdqt.mymvptest.HeadAndFooterRecyclerView.EndlessRecyclerOnScrollListener;
import com.gdqt.mymvptest.HeadAndFooterRecyclerView.HeaderAndFooterRecyclerViewAdapter;
import com.gdqt.mymvptest.R;
import com.gdqt.mymvptest.adapter.RealDataAdapter;
import com.gdqt.mymvptest.common.LoadingFooter;
import com.gdqt.mymvptest.entity.RealDataDetailEvent;
import com.gdqt.mymvptest.ui.base.BaseActivity;
import com.gdqt.mymvptest.ui.realdata.detail.RealDataDetailActivity;
import com.gdqt.mymvptest.utils.DisklrucacheUtils;
import com.gdqt.mymvptest.utils.NetworkUtils;
import com.gdqt.mymvptest.utils.RecyclerViewStateUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

public class RealDataActivity extends BaseActivity implements IRealDataView {
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    private RealDataPresenter mPresenter = null;
    private int mTotal = 0;
    //判断是否属于刷新
    private boolean isRefresh = false;
    private static final String TAG = "RealDataPresenter";
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
    private int mCurrentPage = 1;
    private String COMPANY_ID = "";
    private List<Map<String, Object>> mList = new ArrayList<>();
    private HashMap<String, String> param = new HashMap<>();
    private HeaderAndFooterRecyclerViewAdapter mHeaderAndFooterRecyclerViewAdapter = null;
    @BindView(R.id.rv_realData)
    RecyclerView mRecyclerView;
    private RealDataAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentViewWithNetwork(R.id.ll_realData, R.layout.activity_real_data, "实时监测", true);
        mPresenter = new RealDataPresenter(RealDataActivity.this);
        initPresenter(mPresenter);
        if (NetworkUtils.isNetworkConnected()) {
            initView();
        }



    }


   public void initView() {
            try {
                COMPANY_ID= DisklrucacheUtils.getCompanyID();
            } catch (IOException e) {
                e.printStackTrace();
            }


        if (!COMPANY_ID.equals("")){
            initMap();
            mPresenter.onFirstShowRealData(param, isRefresh);
        }
         refreshLayout.setEnableLoadMore(false);
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                isRefresh = true;
                 if (NetworkUtils.isNetworkConnected()) {
                     initRefreshData();
                 }
                mPresenter.onFirstShowRealData(param,isRefresh);
            }
        });
    }


//初始化刷新后的数据
    void initRefreshData() {
        mCurrentPage = 1;
        mCurrentCounter = 0;
        mTotalCounter = 0;
        mTotal = 0;
      setAskPage(mCurrentPage);
    }

    void initMap() {
        param.clear();
        param.put("COMPANY_ID", COMPANY_ID);
        param.put("sidx", "F.ID");
        param.put("sord", "DESC");
        param.put("rows", REQUEST_COUNT + "");
        param.put("page", mCurrentPage + "");
    }

    @Override
    public void showRecyclerView(List<Map<String, Object>> list, int total) {

        mTotal = total;
        mTotalCounter = mTotal * REQUEST_COUNT;
        mList.clear();
        addItems(list);
        mCurrentCounter += mList.size();
        //解决当进入页面时取消加载，此时onNext事件执行不了即showRecyclerView执行不了，mAdapter为空。
        if (!isRefresh || mAdapter == null) {
            mAdapter = new RealDataAdapter(mList);
            mHeaderAndFooterRecyclerViewAdapter = new HeaderAndFooterRecyclerViewAdapter(mAdapter);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            mRecyclerView.addOnScrollListener(mOnScrollListener);
            mRecyclerView.setAdapter(mHeaderAndFooterRecyclerViewAdapter);
            mAdapter.setItemClickListener(new RealDataAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(int position) {
                    EventBus.getDefault().postSticky(new RealDataDetailEvent(mList.get(position)));
                    startActivity(new Intent(RealDataActivity.this,RealDataDetailActivity.class));
                }
            });
        } else {
            mHeaderAndFooterRecyclerViewAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void notifyDataChange(List<Map<String, Object>> list) {
        addItems(list);
        //当在最后一页时，调整数据总量
        if (mCurrentPage == mTotal) {
            mTotalCounter = (mTotal - 1) * REQUEST_COUNT + list.size();
        }
        mCurrentCounter = mList.size();
        RecyclerViewStateUtils.setFooterViewState(mRecyclerView, LoadingFooter.State.Normal);
    }

    @Override
    public void footerNetWorkError() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                RecyclerViewStateUtils
                        .setFooterViewState(RealDataActivity.this, mRecyclerView, REQUEST_COUNT, LoadingFooter.State.NetWorkError, mFooterClick);
            }
        });


    }



    @Override
    public void setRefreshState(boolean isSuccess) {
        if (refreshLayout!=null){
            refreshLayout.finishRefresh(isSuccess);
        }

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
                        .setFooterViewState(RealDataActivity.this, mRecyclerView, REQUEST_COUNT, LoadingFooter.State.Loading, null);
                //判断是否有网络，如果没有网络则不需要更改数据
                if (NetworkUtils.isNetworkConnected()) {
                    mCurrentPage += 1;
                 setAskPage(mCurrentPage);
                    Log.d(TAG, "onLoadNextPage: " + COMPANY_ID);
                }
                mPresenter.onPageShowRealData(param);
            } else {
                //the end
                RecyclerViewStateUtils
                        .setFooterViewState(RealDataActivity.this, mRecyclerView, REQUEST_COUNT, LoadingFooter.State.TheEnd, null);
            }
        }


    };
    //当网络错误重新点击或加载
    private View.OnClickListener mFooterClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RecyclerViewStateUtils
                    .setFooterViewState(RealDataActivity.this, mRecyclerView, REQUEST_COUNT, LoadingFooter.State.Loading, null);
            Log.d(TAG, "onClick: " + param.toString());
            if (NetworkUtils.isNetworkConnected()){
                mCurrentPage+=1;
               setAskPage(mCurrentPage);
            }
            mPresenter.onPageShowRealData(param);

        }
    };

    private void addItems(List<Map<String, Object>> list) {
        for (Map map : list) {
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
