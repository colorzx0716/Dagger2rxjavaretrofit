package com.bawie.test.presenter;

import com.bawie.test.entity.SearchBean;
import com.bawie.test.model.SearchModel;
import com.bawie.test.view.SearchView;

import javax.inject.Inject;

/**
 * 搜索好友Presenter
 */

public class SearchPresenter implements SearchModel.SearchMessage {

   @Inject
   SearchModel searchModel;
   SearchView searchView;

    @Inject
    public SearchPresenter(SearchView searchView) {
        this.searchView = searchView;
    }

    public void rele(String keywords,String page){
        searchModel.setSearchMessage(this);
        searchModel.getSearch(keywords,page);
    }

    @Override
    public void SearchSuccess(SearchBean value) {
        searchView.SearchSuccess(value);
    }

    @Override
    public void SearchFailure(String msg) {
        searchView.SearchFailure(msg);
    }
}
