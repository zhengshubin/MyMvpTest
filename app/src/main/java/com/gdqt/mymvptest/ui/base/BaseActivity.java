package com.gdqt.mymvptest.ui.base;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gdqt.mymvptest.R;
import com.gdqt.mymvptest.common.ActivityCollector;
import com.gdqt.mymvptest.common.CancelLoadingListener;
import com.gdqt.mymvptest.common.CustomProgressDialog;
import com.gdqt.mymvptest.utils.LogUtils;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.disposables.Disposable;

public class BaseActivity extends RxAppCompatActivity implements IBaseView {
    private static final String TAG = "BaseActivity";
    public Unbinder mUnBinder;
    @BindView(R.id.tool_bar)
    Toolbar mToolBar;
    @BindView(R.id.tv_toolbar_title)
    TextView tvToolbarTitle;
    private CustomProgressDialog mProgressDialog;
    private BasePresenter<IBaseView> mBasePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);


    }


    public void setContentView(int layoutResID) {
        View view = linkLayout(R.layout.layout_toolbar, layoutResID);
        super.setContentView(view);
        setUnbinder(ButterKnife.bind(this, view));
        setSupportActionBar(mToolBar);
        initProgressBar();


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
    public void initPresenter(BasePresenter basePresenter) {
        mBasePresenter = basePresenter;
        mBasePresenter.onAttach(this);


    }

    //初始化加载框
    public void initProgressBar() {
        mProgressDialog = new CustomProgressDialog(this, new CancelLoadingListener() {
            @Override
            public void cancelLoding() {
                Disposable disposable = mBasePresenter.getDisposable();
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
        if (mBasePresenter != null) {
            mBasePresenter.onDetach();
        }
        if (mUnBinder != null) {
            mUnBinder.unbind();
        }
        super.onDestroy();
    }

    @Override
    public void setToolbarTitleOrHomeAsUp(String title, boolean isNeedHomeAsUp) {
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        tvToolbarTitle.setText(title);
        if (isNeedHomeAsUp) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp);
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
