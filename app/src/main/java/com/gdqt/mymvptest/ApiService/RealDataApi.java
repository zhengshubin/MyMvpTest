package com.gdqt.mymvptest.ApiService;

import com.gdqt.mymvptest.entity.AppData;
import com.gdqt.mymvptest.entity.ResultData;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RealDataApi {
    @GET("rest/app/RealTimeMonitoring/RealTimeData/getRealData")
    Observable<ResultData<AppData>> getRealData(@Query("DMA_NAME") String DMA_NAME, @Query("COMPANY_ID") String COMPANY_ID,
                                                @Query("sidx") String sidx, @Query("sord") String sord, @Query("rows") String rows, @Query("page") String page);

    @GET("rest/app/RealTimeMonitoring/RealTimeData/getMapData")
    Observable<ResultData<AppData>> getMapData(@Query("FFM_ID") String FFM_ID);
}
