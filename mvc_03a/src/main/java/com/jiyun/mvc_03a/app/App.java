package com.jiyun.mvc_03a.app;

import android.app.Application;

import com.jiyun.mvc_03a.base.BaseActivity;

/**
 * Created by xingge on 2017/10/23.
 */

public class App extends Application {

    //全局context
    public static BaseActivity context;

    @Override
    public void onCreate() {
        super.onCreate();
        //从数据库中初始化User对象
    }
}
