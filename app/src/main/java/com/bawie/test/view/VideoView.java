package com.bawie.test.view;

import com.bawie.test.Bean;

/**
 * v层
 */

public interface VideoView {

    void userVideoSuccess(Bean value);
    void userVideoFailue(String msg);;

}
