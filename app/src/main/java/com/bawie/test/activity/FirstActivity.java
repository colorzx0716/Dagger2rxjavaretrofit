package com.bawie.test.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.bawie.test.Main2Activity;
import com.bawie.test.R;

import scut.carson_ho.kawaii_loadingview.Kawaii_LoadingView;

public class FirstActivity extends AppCompatActivity {

    private SharedPreferences sp;
    private Kawaii_LoadingView kawaii_loadingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        //手动隐藏标题
        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        sp = getSharedPreferences("sp", MODE_PRIVATE);
        kawaii_loadingView = findViewById(R.id.Kawaii_LoadingView);

        kawaii_loadingView.startMoving();//启动动画

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //点击跳转
                boolean isfirst = sp.getBoolean("isfirst", false);
                if(isfirst){
                    //第二次
                    //跳转到主页面
                    kawaii_loadingView.stopMoving();//结束动画
                    Intent intent = new Intent(FirstActivity.this,ZhuActivity.class);
                    startActivity(intent);
                    finish();
                    overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);

                }else{
                    kawaii_loadingView.stopMoving();//结束动画
                    //第一次
                    Intent intent = new Intent(FirstActivity.this,Main2Activity.class);
                    startActivity(intent);
                    finish();
                    overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);

                }
            }
        },3000);

    }
}
