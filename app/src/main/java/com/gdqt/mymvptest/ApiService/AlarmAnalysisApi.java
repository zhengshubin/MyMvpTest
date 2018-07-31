package com.gdqt.mymvptest.ApiService;

import com.gdqt.mymvptest.entity.AppData;
import com.gdqt.mymvptest.entity.ResultData;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AlarmAnalysisApi {
    @GET("rest/app/AlarmLowerlimitAnalysis/getAlarmLowerlimitData")
    Observable<ResultData<AppData>> getAlarmLowerlimitData(@Query("COMPANY_ID") String COMPANY_ID,
                                                           @Query("sidx") String sidx, @Query("sord") String sord, @Query("rows") String rows, @Query("page") String page, @Query("FFM_NAME") String  FFM_NAME);
    @GET("rest/app/AlarmToplimitAnalysis/getAlarmToplimitData")
    Observable<ResultData<AppData>> getAlarmToplimitData( @Query("COMPANY_ID") String COMPANY_ID,
                                       @Query("sidx") String sidx, @Query("sord") String sord, @Query("rows") String rows, @Query("page") String page,@Query("FFM_NAME") String  FFM_NAME);

}
