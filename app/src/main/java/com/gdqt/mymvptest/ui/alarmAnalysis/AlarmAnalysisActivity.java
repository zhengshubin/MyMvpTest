package com.gdqt.mymvptest.ui.alarmAnalysis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gdqt.mymvptest.R;
import com.gdqt.mymvptest.ui.base.BaseActivity;

import java.util.List;
import java.util.Map;

public class AlarmAnalysisActivity extends BaseActivity implements IAlarmAnalysisView {
    /**
    *上限
    */
    public  static  final  int ALARMTOP=0;
    /**
     *下限
     */
    public  static  final  int ALARMLOWER=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_analysis);
    }

    @Override
    public void showFirstRecyclerView(List<Map<String, Object>> list) {

    }



    @Override
    public void footerLoding(List<Map<String, Object>> list) {

    }

    @Override
    public void loaingWithFFM_Name(List<Map<String, Object>> list) {

    }
}
