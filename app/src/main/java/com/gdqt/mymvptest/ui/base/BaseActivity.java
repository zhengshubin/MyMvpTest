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
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gdqt.mymvptest.Application.MyApplication;
import com.gdqt.mymvptest.R;
import com.gdqt.mymvptest.common.ActivityCollector;
import com.gdqt.mymvptest.common.CancelLoadingListener;
import com.gdqt.mymvptest.common.CustomProgressDialog;
import com.gdqt.mymvptest.utils.LogUtils;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.disposables.Disposable;

public class BaseActivity extends RxAppCompatActivity implements IBaseView {
    private static final String TAG = "BaseActivity";

    private Unbinder mUnBinder;
   private     Toolbar mToolBar;
    private CustomProgressDialog mProgressDialog;

    private BasePresenter mPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
        initProgressBar();


    }



    public void setContentView(int layoutResID, String title, boolean isNeedHomeAsUp) {
       View view = linkLayout(R.layout.layout_toolbar, layoutResID);
       super.setContentView(view);
       setUnbinder(ButterKnife.bind(this,view));
       mToolBar=view.findViewById(R.id.tool_bar);
        mToolBar.setTitle(title);
        setSupportActionBar(mToolBar);
        setHomeAsUp(isNeedHomeAsUp);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        setUnbinder(ButterKnife.bind(this));
    }

    //连接两个布局
    public View linkLayout(int topLayoutResID, int buttomLayoutResID) {
        View topView = LayoutInflater.from(this).inflate(topLayoutResID, null);
        View buttomView = LayoutInflater.from(this).inflate(buttomLayoutResID, null);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.addView(topView);
        linearLayout.addView(buttomView, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        return linearLayout;
    }

    //初始化presenter
    public void initPresenter(BasePresenter presenter) {
        mPresenter =  presenter;
        mPresenter.onAttach(this);


    }

    //初始化加载框
    public void initProgressBar() {
        mProgressDialog = new CustomProgressDialog(this, new CancelLoadingListener() {
            @Override
            public void cancelLoding() {
                Disposable disposable = mPresenter.getDisposable();
                if (disposable != null && !disposable.isDisposed()) {
                    LogUtils.d(TAG, "cancelLoding: " + "dispose");
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

    @Override
    public void setHomeAsUp(boolean isNeedHomeAsUp) {
        ActionBar actionBar=getSupportActionBar();
        if (isNeedHomeAsUp&&actionBar!=null) {

            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp);
        }
    }

    @Override
    public void hideToolbar() {
        mToolBar.setVisibility(View.GONE);
    }


    @Override
    public void showLoding() {

        mProgressDialog.show();


    }

    @Override
    public void hideLoding() {
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
