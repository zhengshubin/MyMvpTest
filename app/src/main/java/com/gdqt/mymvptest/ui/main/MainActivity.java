package com.gdqt.mymvptest.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.gdqt.mymvptest.R;
import com.gdqt.mymvptest.entity.UserInfoEvent;
import com.gdqt.mymvptest.ui.alarmAnalysis.AlarmAnalysisActivity;
import com.gdqt.mymvptest.ui.realdata.RealDataActivity;
import com.gdqt.mymvptest.ui.userinfo.UserInfoActivity;
import com.gdqt.mymvptest.ui.base.BaseActivity;
import com.gdqt.mymvptest.utils.LogUtils;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements IMainView {
    private static final String TAG = "MainActivity";
    private MainPresenter mPresenter = null;
    @BindView(R.id.gv_main)
    GridView gridView;
    @BindView(R.id.tb_main)
    Toolbar toolBar;
    @BindView(R.id.nv_main)
    NavigationView navigationView;
    @BindView(R.id.dl_main)
    DrawerLayout drawerLayout;
    private TextView tv_username;
    private TextView tv_remark;
    private View headView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mPresenter = new MainPresenter<>(this);
        initPresenter(mPresenter);
        initView();

    }

   public void initView() {
        setToolBar();
        headView=navigationView.getHeaderView(0);
        tv_username=headView.findViewById(R.id.tv_head_username);
        tv_remark=headView.findViewById(R.id.tv_head_remark);
        mPresenter.onNav_header();
        mPresenter.onGridView();


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
    public void showNav_header(final Map<String, Object> map) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue().toString();
            LogUtils.d(TAG, "showNav" + key + ":" + value);

        }
        tv_username.setText(map.get("USER_NAME").toString());
        tv_remark.setText(map.get("USER_REMARK").toString());
        headView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              mPresenter.onHeader_click(map);
            }
        });





    }

    @Override
    public void initGridView(ArrayList<HashMap<String,Object>> list) {
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,list, R.layout.item_main_image,new String[]{"image","text"},new int[]{R.id.iv_main_icon, R.id.tv_main_icontext});
        gridView.setAdapter(simpleAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, "onItemClick: "+position);
                switch (position){
                    case 0:startActivity(new Intent(MainActivity.this, RealDataActivity.class));
                    break;
                    case 1:startActivity(new Intent(MainActivity.this, AlarmAnalysisActivity.class));
                    break;
                }
            }
        });

    }

    @Override
    public void OpenUserInfoActivity(UserInfoEvent event) {
        EventBus.getDefault().postSticky(event);
        startActivity(new Intent(MainActivity.this, UserInfoActivity.class));

    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}

