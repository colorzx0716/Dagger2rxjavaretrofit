package com.bawie.test.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bawie.test.DaggerVideoComponent;
import com.bawie.test.R;
import com.bawie.test.VideoComponent;
import com.bawie.test.VideoModule;
import com.bawie.test.adapter.MyZhuAdapter;
import com.bawie.test.entity.UserInfo;
import com.bawie.test.entity.VideosBean;
import com.bawie.test.presenter.UserInfoPresenter;
import com.bawie.test.presenter.VideosPresenter;
import com.bawie.test.util.GlideCircleTransform;
import com.bawie.test.util.ShareprefrensUtils;
import com.bawie.test.view.UserInfoView;
import com.bawie.test.view.VideosView;
import com.bumptech.glide.Glide;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class ZhuActivity extends AppCompatActivity implements View.OnClickListener,UserInfoView,VideosView {

    // /注入对象
    @Inject
    UserInfoPresenter userInfoPresenterr;
    @Inject
    VideosPresenter videosPresenter;

    private XRecyclerView zhu_xrv;
    private ImageView zhu_touxiang;
    private DrawerLayout drawer_layout;
    private ImageView zhu_left_touxiang;
    private Button zhu_left_master;
    private TextView zhu_left_ni;
    private Button zhu_left_shezhi;

    private String page = "1";
    private int p = 1;
    private LinearLayoutManager linearLayoutManager;
    private List<VideosBean.DataBean> data;
    private List<VideosBean.DataBean> list;
    private MyZhuAdapter myZhuAdapter;
    private String uid;
    private Button zhu_left_sousuo;
    private Button zhu_left_guan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhu);
        //手动隐藏标题
        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        initView();

        list = new ArrayList();

        //获取桥梁
        VideoComponent component = DaggerVideoComponent.builder()
                .videoModule(new VideoModule(null,this,this)).build();
        //注入
        component.inject(this);

        uid = (String) ShareprefrensUtils.get(ZhuActivity.this,"uid","");
      //用户信息
        userInfoPresenterr.relevance(uid +"");
        //视频
        videosPresenter.getVP(uid+"","1",p+"");

    }

    private void initView() {
        zhu_xrv = findViewById(R.id.zhu_xrv);
        //刷新加载
        zhu_xrv.setLoadingMoreEnabled(true);
        zhu_xrv.setPullRefreshEnabled(true);
        //头像
        zhu_left_touxiang = findViewById(R.id.zhu_left_touxiang);
        //昵称
        zhu_left_ni = findViewById(R.id.zhu_left_ni);
        //我的设置
        zhu_left_shezhi = findViewById(R.id.zhu_left_shezhi);
        //我的主页,作品
        zhu_left_master = findViewById(R.id.zhu_left_master);
        //搜索好友
        zhu_left_sousuo = findViewById(R.id.zhu_left_sousuo);
        //我的关注
        zhu_left_guan = findViewById(R.id.zhu_left_guan);


        drawer_layout = findViewById(R.id.drawer_layout);
        drawer_layout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
        //头像
        zhu_touxiang = findViewById(R.id.zhu_touxiang);

        //点击头像侧拉
        zhu_touxiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer_layout.openDrawer(Gravity.LEFT);
            }
        });

        //圆形头像
        Glide.with(this).load(R.mipmap.raw_1500033586)
                .bitmapTransform(new GlideCircleTransform(this))
                .into(zhu_touxiang);

        //点击事件
        zhu_left_shezhi.setOnClickListener(this);
        zhu_left_master.setOnClickListener(this);
        zhu_left_sousuo.setOnClickListener(this);
        zhu_left_guan.setOnClickListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.zhu_left_shezhi:
                //跳转到设置页面
                Intent intent = new Intent(ZhuActivity.this,SheZhiActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.bottom_to_top_in, R.anim.bottom_to_top_out);

                break;
            case R.id.zhu_left_master:
                //跳转到我的主页面
                Intent intent2 = new Intent(ZhuActivity.this,MasterActivity.class);
                startActivity(intent2);
                overridePendingTransition(R.anim.bottom_to_top_in, R.anim.bottom_to_top_out);

                break;

            case R.id.zhu_left_sousuo:
                //搜索好友
                Intent intent1 = new Intent(ZhuActivity.this,SSActivity.class);
                startActivity(intent1);
                overridePendingTransition(R.anim.bottom_to_top_in, R.anim.bottom_to_top_out);


                break;
            case R.id.zhu_left_guan:
                //我的关注
                Intent intent3 = new Intent(ZhuActivity.this,GuanActivity.class);
                startActivity(intent3);
                overridePendingTransition(R.anim.bottom_to_top_in, R.anim.bottom_to_top_out);

                break;
        }
    }

    @Override
    public void UserInfoSuccess(UserInfo value) {
        String nickname = value.data.nickname;
        String icon = value.data.icon;

        //头像和昵称
        //圆形头像
        Glide.with(this).load(icon)
                .bitmapTransform(new GlideCircleTransform(this))
               .into(zhu_left_touxiang);
        zhu_left_ni.setText(nickname);

    }

    @Override
    public void UserInfoFailue(String msg) {

        System.out.println("UserInfoFailue = " + msg);
    }

    @Override
    public void VideosSuccess(VideosBean value) {

        for (int i = 0; i < value.data.size(); i++) {
            data = value.data;
        }

        linearLayoutManager = new LinearLayoutManager(this);
        zhu_xrv.setLayoutManager(linearLayoutManager);
        myZhuAdapter = new MyZhuAdapter(this,data);
        zhu_xrv.setAdapter(myZhuAdapter);

        list.addAll(data);

        //适配器判断
        if(myZhuAdapter == null)
        {
            myZhuAdapter = new MyZhuAdapter(this,list);
            zhu_xrv.setAdapter(myZhuAdapter);

        }else
        {
            myZhuAdapter.notifyDataSetChanged();
        }

        zhu_xrv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                //下拉刷新
                list.clear();
                videosPresenter.getVP(uid+"","1",p+"");
                Toast.makeText(ZhuActivity.this, "刷新", Toast.LENGTH_SHORT).show();
                zhu_xrv.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                p++;
                videosPresenter.getVP(uid+"","1",p+"");
                Toast.makeText(ZhuActivity.this, "加载", Toast.LENGTH_SHORT).show();
                zhu_xrv.loadMoreComplete();
            }
        });
    }

    @Override
    public void VideosFailure(String msg) {

    }
}
