package com.bawie.test.view;

import com.bawie.test.entity.SearchBean;

/**
 * 搜索好友View
 */

public interface SearchView {

    void SearchSuccess(SearchBean value);
    void SearchFailure(String msg);
}
