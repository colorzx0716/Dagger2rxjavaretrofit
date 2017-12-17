package com.bawie.test.model;

import com.bawie.test.entity.Bean;
import com.bawie.test.util.HttpUtils;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 *登录m层
 */

public class VideoModel {


    @Inject
    public VideoModel() {

    }

    public void  getServiceData(String mobile, String password){
        new HttpUtils.Builder().
                addConverterFactory()
                .addCallAdapterFactory().build().getMyQusetUtils().getVideoData(mobile,password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Bean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Bean value) {
                        if("0".equals(value.code))
                        {
                            videoMessageInterface.userVideoSuccess(value);
                        }else
                        {
                            videoMessageInterface.userVideoFailue(value.msg);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }
    private VideoMessage videoMessageInterface;

    public void setVideoMessageInterface(VideoMessage videoMessageInterface) {
        this.videoMessageInterface = videoMessageInterface;
    }

    public interface VideoMessage{
        void userVideoSuccess(Bean value);
        void userVideoFailue(String msg);
    }
    }



