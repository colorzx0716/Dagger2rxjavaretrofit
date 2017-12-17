package com.bawie.test.model;

import com.bawie.test.entity.UserInfo;
import com.bawie.test.util.HttpUtils;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * UserInfo 用户信息的model
 */

public class UserInfoModel {

    @Inject
    public UserInfoModel() {

    }

    public void  getgetUserInfoData(String uid){
        new HttpUtils.Builder().
                addConverterFactory()
                .addCallAdapterFactory().build().getMyQusetUtils().getgetUserInfo(uid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserInfo>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UserInfo value) {
                        String code = value.code;
                        if(code.equals("0")){
                            userInfoMessage.UserInfoSuccess(value);
                        }else{
                            userInfoMessage.UserInfoFailue(value.msg);
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

    private UserInfoMessage userInfoMessage;

    public void setUserInfoMessage(UserInfoMessage userInfoMessage) {
        this.userInfoMessage = userInfoMessage;
    }

    public interface UserInfoMessage{
        void UserInfoSuccess(UserInfo value);
        void UserInfoFailue(String msg);
    }

}
