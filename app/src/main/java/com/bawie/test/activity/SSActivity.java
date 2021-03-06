package com.bawie.test.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bawie.test.DaggerVideoComponent;
import com.bawie.test.R;
import com.bawie.test.VideoComponent;
import com.bawie.test.VideoModule;
import com.bawie.test.adapter.MySSAdapter;
import com.bawie.test.entity.SearchBean;
import com.bawie.test.presenter.SearchPresenter;

import java.util.List;

import javax.inject.Inject;

import scut.carson_ho.searchview.ICallBack;
import scut.carson_ho.searchview.SearchView;
import scut.carson_ho.searchview.bCallBack;

//搜索好友
public class SSActivity extends AppCompatActivity implements com.bawie.test.view.SearchView{

    @Inject
    SearchPresenter searchPresenter;
    private SearchView search_view;
    private RecyclerView ss_rv;
    private LinearLayoutManager linearLayoutManager;
    private List<SearchBean.DataBean> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ss);
        //手动隐藏标题
        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        //获取桥梁
        VideoComponent component = DaggerVideoComponent.builder()
                .videoModule(new VideoModule(this)).build();
        //注入
        component.inject(this);

        initView();

    }

    private void initView() {
        //绑定组件
        search_view = findViewById(R.id.search_view);
        ss_rv = findViewById(R.id.ss_rv);

        // 4. 设置点击搜索按键后的操作（通过回调接口）
        // 参数 = 搜索框输入的内容
        search_view.setOnClickSearch(new ICallBack() {
            @Override
            public void SearchAciton(String string) {
                System.out.println("我收到了" + string);
                searchPresenter.rele(string,"1");
            }
        });

        // 5. 设置点击返回按键后的操作（通过回调接口）
        search_view.setOnClickBack(new bCallBack() {
            @Override
            public void BackAciton() {
                finish();
            }
        });

    }


    @Override
    public void SearchSuccess(SearchBean value) {

        for (int i = 0; i < value.data.size(); i++) {
            data = value.data;
        }

        linearLayoutManager = new LinearLayoutManager(this);
        ss_rv.setLayoutManager(linearLayoutManager);
        MySSAdapter adapter = new MySSAdapter(this,data);
        ss_rv.setAdapter(adapter);

    }

    @Override
    public void SearchFailure(String msg) {

    }
}
