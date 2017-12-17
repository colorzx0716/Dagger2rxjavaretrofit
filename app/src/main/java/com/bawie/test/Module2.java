package com.bawie.test;

import com.bawie.test.view.FollowUsersView;
import com.bawie.test.view.VideosView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by 张肖肖 on 2017/12/16.
 */

@Module
public class Module2 {

    private VideosView videosView;

    public Module2(VideosView videosView) {
        this.videosView = videosView;
    }

    @Provides
    VideosView providesVideos(){
        return videosView;
    }

    //关注用户view
    private FollowUsersView followUsersView;

    public Module2(FollowUsersView followUsersView) {
        this.followUsersView = followUsersView;
    }

    @Provides
    FollowUsersView providesFollow(){
        return followUsersView;
    }

}
