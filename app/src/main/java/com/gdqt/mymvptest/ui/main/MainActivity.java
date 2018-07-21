package com.gdqt.mymvptest.ui.main;

import android.os.Bundle;
import android.widget.TextView;

import com.gdqt.mymvptest.R;
import com.gdqt.mymvptest.ui.base.BaseActivity;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements IMainView {
private static final String TAG="MainActivity";
    @BindView(R.id.tv_hello)
    TextView tvHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
     setContentView(R.layout.activity_main);
        setToolbarTitleOrHomeAsUp("主界面",true);

    }

}
