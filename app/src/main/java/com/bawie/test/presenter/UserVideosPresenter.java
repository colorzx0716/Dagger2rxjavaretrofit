package com.bawie.test.presenter;

import com.bawie.test.entity.UserVideosBean;
import com.bawie.test.model.UserVideosModel;
import com.bawie.test.view.UserVideosView;

import javax.inject.Inject;

/**
 * 获取某个用户的视频作品集Presenter
 */

public class UserVideosPresenter implements UserVideosModel.UserVideosMessage {

    @Inject
    UserVideosView userVideosView;
    UserVideosModel userVideosModel;

    @Inject
    public UserVideosPresenter(UserVideosView userVideosView) {
        this.userVideosView = userVideosView;
        userVideosModel = new UserVideosModel();
    }

    public void getUserData(String uid,String page){
        userVideosModel.setUserVideosMessage(this);
        userVideosModel.getUserVideosData(uid,page);

    }


    @Override
    public void UserVideosSuccess(UserVideosBean value) {
        userVideosView.UserVideosSuccess(value);
    }

    @Override
    public void UserVideosFailure(String msg) {
        userVideosView.UserVideosFailure(msg);
    }
}
