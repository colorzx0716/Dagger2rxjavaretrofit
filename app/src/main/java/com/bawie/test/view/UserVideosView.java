package com.bawie.test.view;

import com.bawie.test.entity.UserVideosBean;

/**
 * Created by 张肖肖 on 2017/12/18.
 */

public interface UserVideosView {

    void UserVideosSuccess(UserVideosBean value);
    void UserVideosFailure(String msg);

}
