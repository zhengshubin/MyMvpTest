package com.gdqt.mymvptest.ui.main;

import com.gdqt.mymvptest.ui.base.BasePresenter;
import com.trello.rxlifecycle2.LifecycleProvider;

public class MainPresenter<V extends  IMainView> extends BasePresenter implements IMainPresenter {
    public MainPresenter(LifecycleProvider provider) {
        super(provider);
    }
}
