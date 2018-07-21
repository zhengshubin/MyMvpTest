package com.gdqt.mymvptest.common;

import com.gdqt.mymvptest.entity.HttpResult;
import com.gdqt.mymvptest.entity.ResultData;

import io.reactivex.functions.Function;

public class CustomFunction {
    /**
     * 用来统一处理Http的resultCode,并将HttpResult的Data部分剥离出来返回给subscriber
     *
     * @param <T> Subscriber真正需要的数据类型，也就是Data部分的数据类型
     */
    public static class HttpResultFunc<T> implements Function<HttpResult<T>, T> {
        @Override
        public T apply(HttpResult<T> httpResult) throws Exception {
            if (httpResult.getCount() == 0) {
                throw new ApiException(100);
            }
            return httpResult.getSubjects();
        }


    }

    /**
     * QT后台参数
     *
     * @param <T>
     */
    public static class ResultDataFunc<T> implements Function<ResultData<T>, T> {


        @Override
        public T apply(ResultData<T> resultData) throws Exception {
            if (resultData.getCode() == 0) {
                throw new ApiException(1000);
            }
            if (resultData.getCode() != 1000) {
                throw new ApiException(resultData.getMsg());
            } else {
                return resultData.getData();
            }
        }
    }

}
