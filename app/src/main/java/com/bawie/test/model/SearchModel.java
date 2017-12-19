package com.bawie.test.model;

import com.bawie.test.entity.SearchBean;
import com.bawie.test.util.HttpUtils;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 搜索好友Model
 */

public class SearchModel {

    @Inject
    public SearchModel() {
    }


    public void getSearch(String keywords,String page){
        new HttpUtils.Builder().addCallAdapterFactory()
                .addConverterFactory()
                .build().getMyQusetUtils().getsearch(keywords,page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SearchBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SearchBean value) {
                        String code = value.code;
                        if(code.equals("0")){
                            searchMessage.SearchSuccess(value);
                        }else{
                            searchMessage.SearchFailure(value.msg);
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

    private SearchMessage searchMessage;

    public void setSearchMessage(SearchMessage searchMessage) {
        this.searchMessage = searchMessage;
    }

    public interface SearchMessage{
        void SearchSuccess(SearchBean value);
        void SearchFailure(String msg);
    }

}
