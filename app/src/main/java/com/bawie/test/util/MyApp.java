package com.bawie.test.util;

import android.app.Application;
import android.content.Context;

/**
 * Created by 张肖肖 on 2017/12/12.
 */

public class MyApp extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }
}
