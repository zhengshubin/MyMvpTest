package com.gdqt.mymvptest.ui.realdata;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import com.gdqt.mymvptest.HeadAndFooterRecyclerView.EndlessRecyclerOnScrollListener;
import com.gdqt.mymvptest.HeadAndFooterRecyclerView.HeaderAndFooterRecyclerViewAdapter;
import com.gdqt.mymvptest.R;
import com.gdqt.mymvptest.common.LoadingFooter;
import com.gdqt.mymvptest.common.MyAdapter;
import com.gdqt.mymvptest.ui.base.BaseActivity;
import com.gdqt.mymvptest.utils.NetworkUtils;
import com.gdqt.mymvptest.utils.RecyclerViewStateUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import butterknife.BindView;
import butterknife.ButterKnife;
public class RealDataActivity extends BaseActivity implements IRealDataView {
  private  RealDataPresenter  mPresenter=null;
  private int mTotal=0;
  //判断是否属于刷新
  private boolean isRefresh=false;
  private static final String TAG="RealDataPresenter";
    /**服务器端一共多少条数据*/
    private  int mTotalCounter = 0;

    /**每一页展示多少条数据*/
    private static final int REQUEST_COUNT = 7;

    /**已经获取到多少条数据了*/
    private int mCurrentCounter = 0;
    private int mCurrentPage=1;
private List<Map<String,Object>> mList=new ArrayList<>();
  private HashMap<String,String>param=new HashMap<>();
  private HeaderAndFooterRecyclerViewAdapter mHeaderAndFooterRecyclerViewAdapter=null;
    @BindView(R.id.rv_realData)
    RecyclerView mRecyclerView;
    @BindView(R.id.refresh_realData)
    SwipeRefreshLayout mSwipeRefreshLayout;
    private MyAdapter mAdapter;

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
        mPresenter.onFirstShowRealData(param,isRefresh);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshRecyclerView();
            }
        });



    }

    private void refreshRecyclerView() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                     initRefreshData();
                       mPresenter.onFirstShowRealData(param,isRefresh);
                        mSwipeRefreshLayout.setRefreshing(false);
                    }
                });
            }
        }).start();

    }
//初始化刷新后的数据
    void   initRefreshData(){
        isRefresh=true;
        mCurrentPage=1;
        mCurrentCounter=0;
        mTotalCounter=0;
        mTotal=0;
        initMap();
    }
    void  initMap(){
        param.clear();
        param.put("COMPANY_ID", 1 +"");
        param.put("sidx", "F.ID");
        param.put("sord", "DESC");
        param.put("rows", REQUEST_COUNT+"");
        param.put("page", mCurrentPage+"");
    }

    @Override
    public void showRecyclerView(List<Map<String,Object>> list,int total) {

        mTotal=total;
        mTotalCounter=mTotal*REQUEST_COUNT;
        mList.clear();
        addItems(list);
        mCurrentCounter+=mList.size();
        if (!isRefresh) {
            mAdapter = new MyAdapter(mList);
            mHeaderAndFooterRecyclerViewAdapter = new HeaderAndFooterRecyclerViewAdapter(mAdapter);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            mRecyclerView.addOnScrollListener(mOnScrollListener);
            mRecyclerView.setAdapter(mHeaderAndFooterRecyclerViewAdapter);
        }else {
            mHeaderAndFooterRecyclerViewAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void notifyDataChange(List<Map<String, Object>> list) {
        addItems(list);
        //当在最后一页时，调整数据总量
        if (mCurrentPage==mTotal){
            mTotalCounter=(mTotal-1)*REQUEST_COUNT+list.size();
        }
        mCurrentCounter=mList.size();
        Log.d(TAG, "notifyDataChange: "+mCurrentCounter);
        RecyclerViewStateUtils.setFooterViewState(mRecyclerView, LoadingFooter.State.Normal);
    }

    @Override
    public void footerNetWorkError() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                RecyclerViewStateUtils.setFooterViewState(RealDataActivity.this, mRecyclerView, REQUEST_COUNT, LoadingFooter.State.NetWorkError, mFooterClick);
            }
        });


    }

    //下滑分页加载监听事件
    private EndlessRecyclerOnScrollListener mOnScrollListener = new EndlessRecyclerOnScrollListener(){
        @Override
        public void onLoadNextPage(View view) {
            super.onLoadNextPage(view);
            LoadingFooter.State state = RecyclerViewStateUtils.getFooterViewState(mRecyclerView);
            if(state == LoadingFooter.State.Loading) {

                return;
            }

            if (mCurrentCounter < mTotalCounter) {

                // loading more
                RecyclerViewStateUtils.setFooterViewState(RealDataActivity.this, mRecyclerView, REQUEST_COUNT, LoadingFooter.State.Loading, null);
                //判断是否有网络，如果没有网络则不需要更改数据
                if (NetworkUtils.isNetworkConnected()) {
                    mCurrentPage += 1;
                    initMap();
                }
             mPresenter.onPageShowRealData(param);
            } else {
                //the end
                RecyclerViewStateUtils.setFooterViewState(RealDataActivity.this, mRecyclerView, REQUEST_COUNT, LoadingFooter.State.TheEnd, null);
            }
        }


    };
    //当网络错误重新点击或加载
    private View.OnClickListener mFooterClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RecyclerViewStateUtils.setFooterViewState(RealDataActivity.this, mRecyclerView, REQUEST_COUNT, LoadingFooter.State.Loading, null);
            Log.d(TAG, "onClick: "+param.toString());
            mPresenter.onPageShowRealData(param);

        }
    };
    private void  addItems(List<Map<String,Object>> list){
        for (Map map:list){
            mList.add(map);
        }
    }
   
}
