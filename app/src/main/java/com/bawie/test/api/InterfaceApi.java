package com.bawie.test.api;

import com.bawie.test.entity.Bean;
import com.bawie.test.entity.FollowUsersBean;
import com.bawie.test.entity.SearchBean;
import com.bawie.test.entity.UserInfo;
import com.bawie.test.entity.UserVideosBean;
import com.bawie.test.entity.VideosBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 *接口
 */

public interface InterfaceApi {

    //登录
    @POST("user/login")
    @FormUrlEncoded
    Observable<Bean> getVideoData(@Field("mobile") String mobile, @Field("password") String password);

    //获取用户信息
    @POST("user/getUserInfo")
    @FormUrlEncoded
    Observable<UserInfo> getgetUserInfo(@Field("uid") String uid);

    //获取视频列表作品
    @POST("quarter/getVideos")
    @FormUrlEncoded
    Observable<VideosBean> getVideos(@Field("uid") String uid, @Field("type") String type,@Field("page") String page);


    //获取关注列表
    @POST("quarter/getFollowUsers")
    @FormUrlEncoded
    Observable<FollowUsersBean> getFollowUsers(@Field("uid") String uid);

   //获取某个用户的视频作品集
    @POST("quarter/getUserVideos")
    @FormUrlEncoded
    Observable<UserVideosBean> getUserVideos(@Field("uid") String uid, @Field("page") String page);

    //作品评论
    @POST("quarter/comment")
    @FormUrlEncoded
    Observable<UserVideosBean> getComment(@Field("uid") String uid, @Field("page") String page,@Field("content") String content);

    //搜索好友
    @POST("quarter/searchFriends")
    @FormUrlEncoded
    Observable<SearchBean> getsearch(@Field("keywords") String keywords, @Field("page") String page);


}
