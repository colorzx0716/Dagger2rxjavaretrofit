package com.bawie.test;

import com.bawie.test.view.VideoView;

import dagger.Module;
import dagger.Provides;

/**
 * 容器 实例化对象
 */

@Module
public class VideoModule {

    private VideoView videoView;
 //在容器中实例化对象

    public VideoModule(VideoView videoView) {
        this.videoView = videoView;
    }

    @Provides //实例化对象
    VideoView providesView(){
        return videoView;
    }
}
