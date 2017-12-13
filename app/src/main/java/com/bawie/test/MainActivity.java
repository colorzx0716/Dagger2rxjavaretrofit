package com.bawie.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //注入对象
  /*  @Inject
    Person person;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //传统的方式  Person person =new Person();

        //得到桥梁
      //  VideoComponent videoComponent = DaggerVideoComponent.builder().videoModule(new VideoModule()).build();

        //注入
       // videoComponent.inject(this);




    }
}
