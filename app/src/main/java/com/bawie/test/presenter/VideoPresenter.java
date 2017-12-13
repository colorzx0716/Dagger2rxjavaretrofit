package com.bawie.test.presenter;

import com.bawie.test.Bean;
import com.bawie.test.model.VideoModel;
import com.bawie.test.view.VideoView;

import javax.inject.Inject;

/**
 * Created by 张肖肖 on 2017/12/12.
 */

public class VideoPresenter implements VideoModel.VideoMessage{

    @Inject
    VideoModel videoModel;
    VideoView videoView;
    //CompositeDisposable compositeDisposable;

    //private DisposableSubscriber<Bean.DataBean> disposableSubscriber;

    //@Inject实例化p对象   注入v      p关联v
    @Inject
    public VideoPresenter(VideoView videoView) {
        this.videoView = videoView;

    }

    //p关联m
    public void relevance(String m,String p){
        //compositeDisposable = new CompositeDisposable();
        //Rxjava内存泄漏问题
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
