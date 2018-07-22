package com.gdqt.mymvptest.ui.main;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.gdqt.mymvptest.R;
import com.gdqt.mymvptest.ui.base.BaseActivity;
import com.gdqt.mymvptest.ui.base.BasePresenter;
import com.gdqt.mymvptest.utils.LogUtils;

import java.util.Map;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements IMainView {
    private static final String TAG = "MainActivity";
    private MainPresenter mPresenter=null;
    @BindView(R.id.tb_main)
    Toolbar toolBar;
    @BindView(R.id.nv_main)
    NavigationView navigationView;
    @BindView(R.id.dl_main)
    DrawerLayout drawerLayout;
  private   TextView tv_username;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       mPresenter=new MainPresenter<>(this);
        initPresenter(mPresenter);
        initView();

    }

    void initView() {
        setToolBar();
      mPresenter .onNav_header();



    }


    private void setToolBar() {
        setSupportActionBar(toolBar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);


        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(Gravity.START);
                break;

        }
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }


    @Override
    public void showNav_header(Map<String, Object> map) {
        for (Map.Entry<String,Object> entry:map.entrySet()){
            String  key=entry.getKey();
            String  value=entry.getValue().toString();
            LogUtils.d(TAG,"showNav"+key+":"+value);

        }
        tv_username=navigationView.getHeaderView(0).findViewById(R.id.tv_head_username);
        tv_username.setText(map.get("USER_NAME").toString());


    }
}

