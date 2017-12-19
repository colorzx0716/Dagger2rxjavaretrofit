package com.bawie.test;

import com.bawie.test.view.FollowUsersView;
import com.bawie.test.view.SearchView;
import com.bawie.test.view.UserInfoView;
import com.bawie.test.view.UserVideosView;
import com.bawie.test.view.VideoView;
import com.bawie.test.view.VideosView;

import dagger.Module;
import dagger.Provides;

/**
 * 容器 实例化对象
 */

@Module
public class VideoModule {

    private VideoView videoView;
    private UserInfoView userInfoView;
    private VideosView videosView;

    private FollowUsersView followUsersView;

    private SearchView searchView;

    private UserVideosView UserVideosView;

    public VideoModule(UserVideosView UserVideosView) {
        this.UserVideosView = UserVideosView;
    }

    public VideoModule(SearchView searchView) {
        this.searchView = searchView;
    }

    public VideoModule(VideoView videoView, UserInfoView userInfoView, VideosView videosView) {
        this.videoView = videoView;
        this.userInfoView = userInfoView;
        this.videosView = videosView;
    }

    public VideoModule(VideoView videoView, UserInfoView userInfoView, VideosView videosView, FollowUsersView followUsersView) {
        this.videoView = videoView;
        this.userInfoView = userInfoView;
        this.videosView = videosView;
        this.followUsersView = followUsersView;
    }

    @Provides //实例化对象
    VideoView providesView(){
        return videoView;
    }

    @Provides//实例化对象
    UserInfoView providesUserView(){
        return userInfoView;
    }

    @Provides
    VideosView providesVideos(){
        return videosView;
    }

    //关注用户view
    @Provides
    FollowUsersView providesFollow(){
        return followUsersView;
    }

    //获取某个用户视频列表
    @Provides
    UserVideosView providesup(){
        return UserVideosView;
    }

    //搜索好友
    @Provides
    SearchView providesSearch(){
        return searchView;
    }

}
