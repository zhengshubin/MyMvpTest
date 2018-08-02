package com.gdqt.mymvptest.ui.base;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.gdqt.mymvptest.R;
import com.gdqt.mymvptest.common.ActivityCollector;
import com.gdqt.mymvptest.common.CancelLoadingListener;
import com.gdqt.mymvptest.common.CustomProgressDialog;
import com.gdqt.mymvptest.common.NetworkRefreshListener;
import com.gdqt.mymvptest.utils.LogUtils;
import com.gdqt.mymvptest.utils.NetworkUtils;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import io.reactivex.disposables.Disposable;

public   class BaseActivity extends RxAppCompatActivity implements IBaseView {
    private static final String TAG = "BaseActivity";
private Button  btnRefresh;
    private Unbinder mUnBinder;
    private Toolbar mToolBar;
    private CustomProgressDialog mProgressDialog;
private  View mActivityView;
    private BasePresenter mPresenter;
    private View mNetworkView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
        initProgressBar();
    }






    public void setContentView(int layoutResID, String title, boolean isNeedHomeAsUp) {
        View view = linkLayout(R.layout.layout_toolbar, layoutResID);
        super.setContentView(view);
        setUnbinder(ButterKnife.bind(this, view));
        mToolBar = view.findViewById(R.id.tool_bar);
        mToolBar.setTitle(title);
        setSupportActionBar(mToolBar);
        setHomeAsUp(isNeedHomeAsUp);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        setUnbinder(ButterKnife.bind(this));

    }
    public void setContentViewWithNetwork(int activityID, int layoutResID, String title, boolean isNeedHomeAsUp){
                            if (!NetworkUtils.isNetworkConnected()){
                                final View view=linkView(inflate(R.layout.layout_toolbar),linkRelativeLayout(R.layout.network_error,layoutResID));
                                super.setContentView(view);
                                setUnbinder(ButterKnife.bind(this, view));
                                mToolBar = view.findViewById(R.id.tool_bar);
                                mToolBar.setTitle(title);
                                setSupportActionBar(mToolBar);
                                setHomeAsUp(isNeedHomeAsUp);
                                btnRefresh=view.findViewById(R.id.btn_error_refresh);
                                mNetworkView=view.findViewById(R.id.ll_network_error);
                                mActivityView=view.findViewById(activityID);
                                mActivityView.setVisibility(View.GONE);
                                btnRefresh.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        if (!NetworkUtils.isNetworkConnected()){
                                            onError(R.string.connectException);
                                            return;
                                        }else {
                                            mActivityView.setVisibility(View.VISIBLE);
                                            mNetworkView.setVisibility(View.GONE);
                                            initView();
                    }
                }
            });
        }else {
            setContentView(layoutResID, title, isNeedHomeAsUp);

        }

    }

    public View  linkRelativeLayout(int layoutResID1,int layoutResID2){
        View view1=inflate(layoutResID1);
        View view2=inflate(layoutResID2);
        RelativeLayout relativeLayout=new RelativeLayout(this);
        relativeLayout.addView(view1,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        relativeLayout.addView(view2,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        return relativeLayout;

    }




    //连接两个布局
    public View linkLayout(int topLayoutResID, int buttomLayoutResID) {
        View topView =inflate(topLayoutResID);
        View buttomView =inflate(buttomLayoutResID);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.addView(topView);
        linearLayout
                .addView(buttomView, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        return linearLayout;
    }



    public View linkView(View view1,View  view2){
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.addView(view1);
        linearLayout
                .addView(view2, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        return linearLayout;

    }
    public View inflate(int layoutResID){
        return LayoutInflater.from(this).inflate(layoutResID,null);
    }


    //初始化presenter
    public void initPresenter(BasePresenter presenter) {
        mPresenter = presenter;
        mPresenter.onAttach(this);


    }
    /**
    * 初始化界面
    */
    public   void initView(){

    };


    //初始化加载框
    public void initProgressBar() {
        mProgressDialog = new CustomProgressDialog(this, new CancelLoadingListener() {
            @Override
            public void cancelLoding() {
                Disposable disposable = mPresenter.getDisposable();
                if (disposable != null && !disposable.isDisposed()) {
                    LogUtils.d(TAG, "cancelLoading: " + "dispose");
                    disposable.dispose();
                }

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                break;
        }
        return true;
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        ActivityCollector.removeActivity(this);
        if (mPresenter != null) {
            mPresenter.onDetach();
        }
        if (mUnBinder != null) {
            mUnBinder.unbind();
        }
        super.onDestroy();

    }

    public void setHomeAsUp(boolean isNeedHomeAsUp) {
        ActionBar actionBar = getSupportActionBar();
        if (isNeedHomeAsUp && actionBar != null) {

            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp);
        }
    }



    @Override
    public void showLoading() {

        mProgressDialog.show();


    }

    @Override
    public void hideLoading() {
        mProgressDialog.cancel();

    }


    @Override
    public void onError(int resID) {
        onError(getString(resID));

    }

    @Override
    public void onError(String message) {
        Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void netDisconnect() {
        onError(R.string.connectException);
    }


    public void setUnbinder(Unbinder unBinder) {
        mUnBinder = unBinder;
    }

}
