package com.bawie.test.activity;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawie.test.R;
import com.bawie.test.fragment.LocalFragment;
import com.bawie.test.fragment.UploadFragment;

/**
 * 我的主页
 */
public class MasterActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView master_img;
    private TextView master_bendi;
    private View master_bendi_v;
    private TextView master_shangchuan;
    private View master_shangchuan_v;


    private LocalFragment localFragment;
    private UploadFragment uploadFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master);
        //手动隐藏标题
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        localFragment = new LocalFragment();
        uploadFragment = new UploadFragment();

        initView();

    }

    private void initView() {
        //返回键
        master_img = findViewById(R.id.master_img);
        //本地
        master_bendi = findViewById(R.id.master_bendi);
        master_bendi_v = findViewById(R.id.master_bendi_v);
        //已上传
        master_shangchuan = findViewById(R.id.master_shangchuan);
        master_shangchuan_v = findViewById(R.id.master_shangchuan_v);


        //默认点击事件
        master_img.setOnClickListener(this);
        master_bendi.setOnClickListener(this);
        master_shangchuan.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.master_img:
                finish();//返回

                break;
            case R.id.master_bendi:
                //本地
                master_bendi.setTextColor(Color.parseColor("#33ccff"));
                master_bendi_v.setBackgroundColor(Color.parseColor("#33ccff"));
                master_shangchuan.setTextColor(Color.parseColor("#000000"));
                master_shangchuan_v.setBackgroundColor(Color.parseColor("#ffffff"));

                getSupportFragmentManager().beginTransaction().replace(R.id.master_flt,localFragment).commit();

                break;
            case R.id.master_shangchuan:
                //已上传
                master_shangchuan.setTextColor(Color.parseColor("#33ccff"));
                master_shangchuan_v.setBackgroundColor(Color.parseColor("#33ccff"));
                master_bendi.setTextColor(Color.parseColor("#000000"));
                master_bendi_v.setBackgroundColor(Color.parseColor("#ffffff"));

                getSupportFragmentManager().beginTransaction().replace(R.id.master_flt,uploadFragment).commit();

                break;
        }

    }

}
