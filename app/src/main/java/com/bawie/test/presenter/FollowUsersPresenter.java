package com.bawie.test.presenter;

import com.bawie.test.entity.FollowUsersBean;
import com.bawie.test.model.FollowUsersModel;
import com.bawie.test.view.FollowUsersView;

import javax.inject.Inject;

/**
 * 关注用户列表的Presenter
 */

public class FollowUsersPresenter implements FollowUsersModel.FollowUserMessage {

     @Inject
     FollowUsersView followUsersView;
     FollowUsersModel followUsersModel;

     @Inject
    public FollowUsersPresenter(FollowUsersView followUsersView) {
        this.followUsersView = followUsersView;
        followUsersModel = new FollowUsersModel();
    }

    public void getFollowUsers(String uid){
        followUsersModel.setFollowUserMessage(this);
        followUsersModel.getFollowData(uid);

    }


    @Override
    public void followUserSuccess(FollowUsersBean value) {
        followUsersView.followUserSuccess(value);
    }

    @Override
    public void followUserFailue(String msg) {
        followUsersView.followUserFailue(msg);
    }
}
