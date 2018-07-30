package com.gdqt.mymvptest.ui.realdata;

import android.util.Log;

import com.gdqt.mymvptest.utils.DisklrucacheUtils;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class RealDataModelTest {

    @Test
    public void getCompanyID() {
        Log.d("RealDataModelTest", "getCompanyID: "+ DisklrucacheUtils.getLocalData().get(0).get("userCompany").toString());

    }
}