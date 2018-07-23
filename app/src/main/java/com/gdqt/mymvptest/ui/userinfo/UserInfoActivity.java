package com.gdqt.mymvptest.ui.userinfo;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.gdqt.mymvptest.R;
import com.gdqt.mymvptest.entity.UserInfoEvent;
import com.gdqt.mymvptest.ui.base.BaseActivity;
import com.gdqt.mymvptest.utils.LogUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import java.util.Map;

import butterknife.BindView;

public class UserInfoActivity extends BaseActivity implements IUserInfoView{
    private final  String TAG="UserInfoActivity";
    private UserInfoPresenter mPresenter=null;
    @BindView(R.id.tv_userinfo_username)
    TextView  tv_username;
    @BindView(R.id.tv_userinfo_password)
    TextView tv_password;
    @BindView(R.id.tv_userinfo_nickname)
    TextView tv_nickname;
    @BindView(R.id.tv_userinfo_remark)
    TextView tv_remark;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userinfo,"个人信息",true);
        mPresenter=new UserInfoPresenter(this);
        initPresenter(mPresenter);


    }
    void initView(){


    }
    //EventBus 接受MainActivity发送的信息
    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void onUserInfoEvent(UserInfoEvent event){
        LogUtils.d(TAG,"onUserInfoEvent:"+event.getMap());
        mPresenter.onShow_userInfo(event);
    }




    @Override
    protected void onStart() {
        EventBus.getDefault().register(this);
        super.onStart();

    }

    @Override
    protected void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();

    }

    @Override
    public void showUserInfo(Map<String,Object> map) {
        tv_username.setText(map.get("USER_NAME").toString());
        tv_password.setText(map.get("USER_PASSWORD").toString());
        tv_remark.setText(map.get("USER_REMARK").toString());
        tv_nickname.setText(map.get("USER_NICKNAME").toString());


    }
}
