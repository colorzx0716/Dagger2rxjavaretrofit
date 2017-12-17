package com.bawie.test.presenter;

import com.bawie.test.entity.UserInfo;
import com.bawie.test.model.UserInfoModel;
import com.bawie.test.view.UserInfoView;

import javax.inject.Inject;

/**
 * UserInfo用户信息的Presenter
 */

public class UserInfoPresenter implements UserInfoModel.UserInfoMessage {

    @Inject
    UserInfoModel userInfoModel;
    UserInfoView userInfoView;

    @Inject
    public UserInfoPresenter(UserInfoView userInfoView) {
        this.userInfoView = userInfoView;
    }

    //p关联m
    public void relevance(String uid){

        userInfoModel.setUserInfoMessage(this);
        userInfoModel.getgetUserInfoData(uid);
    }

    @Override
    public void UserInfoSuccess(UserInfo value) {
        userInfoView.UserInfoSuccess(value);
    }

    @Override
    public void UserInfoFailue(String msg) {
        userInfoView.UserInfoFailue(msg);
    }
}
