package com.bawie.test.view;

import com.bawie.test.entity.FollowUsersBean;

/**
 * 获取关注列表的view
 */

public interface FollowUsersView {

    void followUserSuccess(FollowUsersBean value);
    void followUserFailue(String msg);

}
