package com.bawie.test;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawie.test.activity.ZhuActivity;
import com.bawie.test.entity.Bean;
import com.bawie.test.presenter.VideoPresenter;
import com.bawie.test.util.ShareprefrensUtils;
import com.bawie.test.view.VideoView;

import javax.inject.Inject;

public class Main2Activity extends AppCompatActivity implements VideoView {

    @Inject//注入对象
    VideoPresenter presenter;

    private EditText et_m;
    private EditText et_p;
    private Button btn;
    private String m;
    private String p;
    private Button btn2;
    private SharedPreferences sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //手动隐藏标题
        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        sp = getSharedPreferences("sp", MODE_PRIVATE);

        initView();
        //获取桥梁
        VideoComponent component = DaggerVideoComponent.builder()
                .videoModule(new VideoModule(this,null,null)).build();
        //注入
        component.inject(this);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sp.edit().putBoolean("isfirst",false).commit();
                //p调用关联m方法
                m = et_m.getText().toString();
                p = et_p.getText().toString();
                presenter.relevance(m,p);
            }
        });

    }

    private void initView() {

        et_m = findViewById(R.id.et_m);
        et_p = findViewById(R.id.et_p);
        btn = findViewById(R.id.btn);
        btn2 = findViewById(R.id.btn2);

        //自动跳转页面
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Main2Activity.this, ZhuActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.bottom_to_top_in, R.anim.bottom_to_top_out);
                finish();

            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解除关联
    }


    @Override
    public void userVideoSuccess(Bean value) {
        //获取数据
        Toast.makeText(this, value.msg, Toast.LENGTH_SHORT).show();
        String nickname = value.data.nickname;
        System.out.println("=====nickname===="+nickname);

        ShareprefrensUtils.put(this,"uid",value.data.uid+"");
        ShareprefrensUtils.put(this,"token",value.data.token+"");

        SharedPreferences.Editor edit = sp.edit();
        edit.putBoolean("isfirst",true).commit();//提交

        //跳转页面
            Intent intent = new Intent(Main2Activity.this, ZhuActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.bottom_to_top_in, R.anim.bottom_to_top_out);
            finish();

    }

    @Override
    public void userVideoFailue(String msg) {
        Toast.makeText(this,msg, Toast.LENGTH_SHORT).show();
    }
}
