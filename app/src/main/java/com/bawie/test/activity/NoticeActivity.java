package com.bawie.test.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bawie.test.R;

public class NoticeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);
        //手动隐藏标题
        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
        }





    }
}
