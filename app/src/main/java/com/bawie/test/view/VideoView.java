package com.bawie.test.view;

import com.bawie.test.entity.Bean;

/**
 *登录 v层
 */

public interface VideoView {

    void userVideoSuccess(Bean value);
    void userVideoFailue(String msg);;

}
