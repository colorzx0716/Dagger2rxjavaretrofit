package com.bawie.test.presenter;

import com.bawie.test.entity.VideosBean;
import com.bawie.test.model.VideosModel;
import com.bawie.test.view.VideosView;

import javax.inject.Inject;

/**
 * Created by 张肖肖 on 2017/12/15.
 */

public class VideosPresenter implements VideosModel.VideosMessage {

    @Inject
    VideosView videosView;
    VideosModel videosModel;

    @Inject
    public VideosPresenter(VideosView videosView) {
        this.videosView = videosView;
        videosModel = new VideosModel();
    }

    //p关联m
    public void getVP(String uid,String type,String page){
        videosModel.setVideosMessage(this);

        videosModel.getVideosData(uid,type,page);

    }

    @Override
    public void VideosSuccess(VideosBean value) {
        videosView.VideosSuccess(value);
    }

    @Override
    public void VideosFailure(String msg) {
        videosView.VideosFailure(msg);
    }
}
