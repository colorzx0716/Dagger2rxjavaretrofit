package com.bawie.test;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bawie.test.activity.ZhuActivity;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = getSharedPreferences("first", MODE_PRIVATE);
        boolean first = sp.edit().putBoolean("first", true).commit();
        if(first){
           sp.edit().putBoolean("first",false).commit();

            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            startActivity(intent);
            finish();
        }else if (first == false){
            Intent intent = new Intent(MainActivity.this, ZhuActivity.class);
            startActivity(intent);
            finish();

        }

    }
}
