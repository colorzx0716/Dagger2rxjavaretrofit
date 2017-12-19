package com.bawie.test.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bawie.test.R;

//我的收藏页面
public class CollectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);
        //手动隐藏标题
        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
        }






    }
}
