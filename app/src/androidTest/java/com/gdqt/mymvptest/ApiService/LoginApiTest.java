package com.gdqt.mymvptest.ApiService;

import android.util.Log;

import com.gdqt.mymvptest.common.RetrofitManager;
import com.gdqt.mymvptest.entity.AppData;
import com.gdqt.mymvptest.entity.ResultData;

import org.junit.Before;
import org.junit.Test;

import java.util.Observable;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static org.junit.Assert.*;

public class LoginApiTest {
    private  static final String TAG="LoginApiTest";
private Call<ResultData<AppData>> call;

     private interface   TestApi {

    @GET("rest/app/system/login")
    Call<ResultData<AppData>> login(@Query("USER_NAME") String USER_NAME, @Query("USER_PASSWORD") String USER_PASSWORD);
}
@Before
  public  void  getCall(){
        TestApi  testApi=RetrofitManager.getSingleton().getRetrofit().create(TestApi.class);
  call=   testApi.login("admin","123456");
}
    @Test
    public void login() {
         call.enqueue(new Callback<ResultData<AppData>>() {
             @Override
             public void onResponse(Call<ResultData<AppData>> call, Response<ResultData<AppData>> response) {
                 Log.d(TAG, "onResponse: "+response.body().toString());
             }

             @Override
             public void onFailure(Call<ResultData<AppData>> call, Throwable t) {

             }
         });
    }
}