package com.gdqt.mymvptest.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.gdqt.mymvptest.ui.main.MainActivity;
import com.gdqt.mymvptest.R;
import com.gdqt.mymvptest.ui.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements ILoginView  {
    private LoginPresenter<ILoginView> mPresenter = new LoginPresenter(this);
    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_login);
       initView();

    }
void  initView(){
    initPresenter(mPresenter);
    hideToolbar();
    mPresenter.autoLogin();


}

    @Override
    public void autoLoginView() {
         this.finish();
        startActivity(new Intent(this,MainActivity.class));
    }

    @Override
    public void loginSucess() {
      startActivity(new Intent(this, MainActivity.class));


    }

    @OnClick(R.id.btn_login)

    void  onBtn_loginClick(){
        mPresenter.onLoginClick(etUsername.getText().toString(), etPassword.getText().toString());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
