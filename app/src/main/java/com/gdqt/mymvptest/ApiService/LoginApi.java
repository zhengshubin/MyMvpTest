package com.gdqt.mymvptest.ApiService;

import com.gdqt.mymvptest.entity.AppData;
import com.gdqt.mymvptest.entity.ResultData;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface LoginApi {
    @GET("rest/app/system/login")
    Observable<ResultData<AppData>> login(@Query("USER_NAME") String USER_NAME, @Query("USER_PASSWORD") String USER_PASSWORD);

    @GET("rest/app/system/logout")
    Observable<ResultData<AppData>> logout();
}
