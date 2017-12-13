package com.bawie.test;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 *接口
 */

public interface InterfaceApi {

    //https://www.zhaoapi.cn/user/login
    @POST("user/login")
    @FormUrlEncoded
    Observable<Bean> getVideoData(@Field("mobile") String mobile, @Field("password") String password);




}
