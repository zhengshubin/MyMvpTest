package com.gdqt.mymvptest.ui.login;

import android.text.TextUtils;

import com.gdqt.mymvptest.R;
import com.gdqt.mymvptest.ui.base.BasePresenter;
import com.gdqt.mymvptest.entity.AppData;
import com.gdqt.mymvptest.entity.LoginSPInfo;
import com.gdqt.mymvptest.common.MyObserver;
import com.gdqt.mymvptest.common.ValueCallBack;
import com.gdqt.mymvptest.utils.DisklrucacheUtils;
import com.gdqt.mymvptest.utils.NetworkUtils;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;

import java.io.IOException;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LoginPresenter<V extends ILoginView> extends BasePresenter<V> implements ILoginPresenter<V> {
    private static final String TAG = "LoginPresenter";
    private LoginModel loginModel=null;
    protected LoginPresenter(LifecycleProvider<ActivityEvent> provider) {
        super(provider);
        loginModel=new LoginModel();
        
    }


    @Override
    public void onLoginClick(final String username, final String password) {

        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
          getView().onError(R.string.user_null);
            return;
        }
        //网络
        if (!NetworkUtils.isNetworkConnected()){
            getView().netDisconnect();
            return;
        }
       getView().showLoading();
        final MyObserver myObserver = new MyObserver(new ValueCallBack<AppData<Map<String, Object>>>() {


            @Override
            public void onSubscribe(Disposable d) {
                             setDisposable(d);

            }

            @Override
            public void onNext(AppData<Map<String, Object>> subjects) {
                if (!isViewAttached()){
                    return;
                }
                try {
                    if (DisklrucacheUtils.setLocalData(subjects.getList())) {
                        getView().hideLoading();
                        getView().loginSuccess();
                        saveLoginInfo(username,password);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }


            @Override
            public void onError(Throwable e) {
                if (!isViewAttached()){
                    return;
                }
                getView().hideLoading();
                getView().onError(e.getMessage());

            }

            @Override
            public void onComplete() {



            }
        });
loginModel.login(username,password,myObserver,getProvider());


    }

    @Override
    public void saveLoginInfo(String username, String password) {
        loginModel.setDataToSP(username,password);
    }

    @Override
    public void autoLogin() {
        LoginSPInfo info = loginModel.getDataFromSP();
        if (info.isLogined()) {
            getView().autoLoginView();

        }
    }
}
