package com.gdqt.mymvptest.ui.base;

import android.support.annotation.StringRes;

import butterknife.BindString;

public interface IBaseView<T > {
    void setHomeAsUp(boolean isNeedHomeAsUp);

void hideToolbar();
   void  showLoding();
   void hideLoding();
   void  onError(int resId );
   void onError(String message);
   void netDisconnect();


}
