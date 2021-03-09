package com.example.databindingdemo;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

/**
 * @CreateDate: 2021-3-9 18:23
 * @UpdateDate: 2021-3-9 18:23
 * @Description:
 * @Author: uidq2189
 * @UpdateRemark:
 * @Version: 1.0
 */
public class App extends Application {

    @SuppressLint("StaticFieldLeak")
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }
}
