package com.bawie.test.model;

import com.bawie.test.entity.UserVideosBean;
import com.bawie.test.util.HttpUtils;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 *获取某个用户的视频作品集model
 */

public class UserVideosModel {

    @Inject
    public UserVideosModel() {
    }

    public void getUserVideosData(String uid,String page){
        new HttpUtils.Builder()
                .addConverterFactory()
                .addCallAdapterFactory().build().getMyQusetUtils().getUserVideos(uid,page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserVideosBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(UserVideosBean value) {

                        String code = value.code;
                        if(code.equals("0")){
                            userVideosMessage.UserVideosSuccess(value);
                        }else{
                            userVideosMessage.UserVideosFailure(value.msg);
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

    private UserVideosMessage userVideosMessage;

    public void setUserVideosMessage(UserVideosMessage userVideosMessage) {
        this.userVideosMessage = userVideosMessage;
    }

    public interface UserVideosMessage{
        void UserVideosSuccess(UserVideosBean value);
        void UserVideosFailure(String msg);
    }




}
