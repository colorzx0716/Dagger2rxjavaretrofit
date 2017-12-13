package com.bawie.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawie.test.presenter.VideoPresenter;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //手动隐藏标题
        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
        initView();
        //获取桥梁
        VideoComponent component = DaggerVideoComponent.builder()
                .videoModule(new VideoModule(this)).build();
        //注入
        component.inject(this);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
        String mobile = value.data.mobile;
        String nickname = value.data.nickname;
        System.out.println("=====mobile===="+mobile);
        System.out.println("=====nickname===="+nickname);
    }

    @Override
    public void userVideoFailue(String msg) {
        Toast.makeText(this,msg, Toast.LENGTH_SHORT).show();
    }
}
