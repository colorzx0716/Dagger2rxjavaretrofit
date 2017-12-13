package com.bawie.test;

import dagger.Component;

/**
 * 桥梁，关联容器和调用者
 */

@Component(modules = VideoModule.class)//关联VideoModule
public interface VideoComponent {

    void inject(Main2Activity main2Activity);

}
