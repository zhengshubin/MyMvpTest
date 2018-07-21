package com.gdqt.mymvptest.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.gdqt.mymvptest.Application.MyApplication;
import com.gdqt.mymvptest.entity.LoginSPInfo;

import java.util.HashMap;
import java.util.Map;

/**
 * author:zhengshubin
 * create：2018/7/19
 * description:该类为SharedPreferences的工具类
 */
public class SPUtils {

    public static class LoginSP {
        private static final String SP_NAME = "USER_INFO";
        private static final String ISLOGINED = "ISLOGINED";
        private static final String USER_NAME = "USER_NAME";
        private static final String USER_PASSWORD = "USER_PASSWORD";
        private static SharedPreferences sp = MyApplication.getContext()
                .getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);

        public static LoginSPInfo getLoginData() {
            LoginSPInfo info = new LoginSPInfo();
            info.setLogined(sp.getBoolean(ISLOGINED, false));
            info.setUsername(sp.getString(USER_NAME, null));
            return info;
        }

        public static void setLoginData(LoginSPInfo info) {
            SharedPreferences.Editor editor = sp.edit();
            editor.putBoolean(ISLOGINED,info.isLogined());
            editor.putString(USER_NAME, info.getUsername());
            editor.putString(USER_PASSWORD, info.getPassword());
            editor.commit();
        }

        public static void LogOut() {
            SharedPreferences.Editor editor = sp.edit();
            editor.clear();
            editor.commit();
        }


    }

}
