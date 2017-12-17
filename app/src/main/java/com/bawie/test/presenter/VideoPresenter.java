package com.bawie.test.presenter;

import com.bawie.test.entity.Bean;
import com.bawie.test.model.VideoModel;
import com.bawie.test.view.VideoView;

import javax.inject.Inject;

/**
 * 登录Presenter
 */

public class VideoPresenter implements VideoModel.VideoMessage{

    @Inject
    VideoModel videoModel;
    VideoView videoView;

    //@Inject实例化p对象   注入v      p关联v
    @Inject
    public VideoPresenter(VideoView videoView) {
        this.videoView = videoView;

    }

    //p关联m
    public void relevance(String m,String p){
        videoModel.setVideoMessageInterface(this);
        videoModel.getServiceData(m,p);
    }

    @Override
    public void userVideoSuccess(Bean value) {
        videoView.userVideoSuccess(value);
    }

    @Override
    public void userVideoFailue(String msg) {
        videoView.userVideoFailue(msg);
    }

}
