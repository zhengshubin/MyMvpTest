package com.gdqt.mymvptest.ui.base;

public interface IBasePresenter<V extends  IBaseView>{
    void onAttach(V mView);
    void  onDetach();


}
