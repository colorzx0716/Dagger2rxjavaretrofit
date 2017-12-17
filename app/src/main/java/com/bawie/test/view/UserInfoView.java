package com.bawie.test.view;

import com.bawie.test.entity.UserInfo;

/**
 * UserInfo用户信息的View
 */

public interface UserInfoView {

    void UserInfoSuccess(UserInfo value);
    void UserInfoFailue(String msg);

}
