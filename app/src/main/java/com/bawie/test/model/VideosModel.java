package com.bawie.test.model;

import com.bawie.test.entity.VideosBean;
import com.bawie.test.util.HttpUtils;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 张肖肖 on 2017/12/15.
 */

public class VideosModel {

    @Inject
    public VideosModel() {
    }

    public void getVideosData(String uid,String type,String page){
        new HttpUtils.Builder()
                .addCallAdapterFactory()
                .addConverterFactory()
                .build().getMyQusetUtils().getVideos(uid,type,page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<VideosBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(VideosBean value) {
                        String code = value.code;

                        if(code.equals("0")){
                            videosMessage.VideosSuccess(value);
                        }else{
                            videosMessage.VideosFailure(value.msg);
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

    private VideosMessage videosMessage;

    public void setVideosMessage(VideosMessage videosMessage) {
        this.videosMessage = videosMessage;
    }

    public interface VideosMessage{
        void VideosSuccess(VideosBean value);
        void VideosFailure(String msg);
    }

}
