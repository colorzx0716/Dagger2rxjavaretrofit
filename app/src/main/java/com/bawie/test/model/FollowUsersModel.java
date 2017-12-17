package com.bawie.test.model;

import com.bawie.test.entity.FollowUsersBean;
import com.bawie.test.util.HttpUtils;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 获取关注用户列表m
 */

public class FollowUsersModel {

    @Inject
    public FollowUsersModel() {
    }

   public void getFollowData(String uid){
       new HttpUtils.Builder().
               addConverterFactory()
               .addCallAdapterFactory().build().getMyQusetUtils().getFollowUsers(uid)
               .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
              .subscribe(new Observer<FollowUsersBean>() {
                  @Override
                  public void onSubscribe(Disposable d) {

                  }

                  @Override
                  public void onNext(FollowUsersBean value) {
                      String code = value.code;
                      if(code.equals("0")){
                          followUserMessage.followUserSuccess(value);
                      }else{
                          followUserMessage.followUserFailue(value.msg);
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

   private FollowUserMessage followUserMessage;

    public void setFollowUserMessage(FollowUserMessage followUserMessage) {
        this.followUserMessage = followUserMessage;
    }

    public interface FollowUserMessage{
       void followUserSuccess(FollowUsersBean value);
       void followUserFailue(String msg);
   }


}
