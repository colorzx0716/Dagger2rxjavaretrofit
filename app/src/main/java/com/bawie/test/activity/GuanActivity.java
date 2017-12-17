package com.bawie.test.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bawie.test.DaggerVideoComponent;
import com.bawie.test.R;
import com.bawie.test.VideoComponent;
import com.bawie.test.VideoModule;
import com.bawie.test.adapter.MyGuanAdapter;
import com.bawie.test.entity.FollowUsersBean;
import com.bawie.test.presenter.FollowUsersPresenter;
import com.bawie.test.util.ShareprefrensUtils;
import com.bawie.test.view.FollowUsersView;

import java.util.List;

import javax.inject.Inject;

//关注列表
public class GuanActivity extends AppCompatActivity implements View.OnClickListener,FollowUsersView {

    // /注入对象
    @Inject
    FollowUsersPresenter followUsersPresenter;

    private ImageView guan_img;
    private TextView guan_remen;
    private RecyclerView guan_rv;
    private String uid;
    private LinearLayoutManager linearLayoutManager;
    private List<FollowUsersBean.DataBean> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guan);

        initView();

        //获取桥梁
        VideoComponent component = DaggerVideoComponent.builder()
                .videoModule(new VideoModule(null,null,null,this)).build();
        //注入
        component.inject(this);

        uid = (String) ShareprefrensUtils.get(GuanActivity.this,"uid","");
        followUsersPresenter.getFollowUsers(uid+"");


    }

    private void initView() {
        guan_img = findViewById(R.id.guan_img);
        guan_remen = findViewById(R.id.guan_remen);
        guan_rv = findViewById(R.id.guan_rv);

        //点击事件
        guan_img.setOnClickListener(this);
        guan_remen.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.guan_img:
                finish();//返回
                break;
            case R.id.guan_remen:
                Toast.makeText(this, "点击热门", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void followUserSuccess(FollowUsersBean value) {

        for (int i = 0; i < value.data.size(); i++) {
            data = value.data;
        }

        linearLayoutManager = new LinearLayoutManager(this);
        guan_rv.setLayoutManager(linearLayoutManager);
        MyGuanAdapter adapter = new MyGuanAdapter(this,data);
        guan_rv.setAdapter(adapter);

    }

    @Override
    public void followUserFailue(String msg) {

    }
}
