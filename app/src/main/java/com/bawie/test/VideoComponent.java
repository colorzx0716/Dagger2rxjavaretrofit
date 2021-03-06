package com.bawie.test;

import com.bawie.test.activity.GuanActivity;
import com.bawie.test.activity.SSActivity;
import com.bawie.test.activity.ZhuActivity;
import com.bawie.test.fragment.UploadFragment;

import dagger.Component;

/**
 * 桥梁，关联容器和调用者
 */

@Component(modules =VideoModule.class)//关联VideoModule
public interface VideoComponent {

    void inject(Main2Activity main2Activity);

    void inject(ZhuActivity zhuActivity);

    void inject(GuanActivity guanActivity);

    void inject(UploadFragment uploadFragment);

    void inject(SSActivity ssActivity);

}
