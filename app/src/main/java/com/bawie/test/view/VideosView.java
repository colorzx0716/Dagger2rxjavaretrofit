package com.bawie.test.view;

import com.bawie.test.entity.VideosBean;

/**
 * Created by 张肖肖 on 2017/12/15.
 */

public interface VideosView {
    void VideosSuccess(VideosBean value);
    void VideosFailure(String msg);

}
