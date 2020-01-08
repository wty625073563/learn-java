package com.example.music;

import android.app.Application;

// 引用被打开的时候，会立即运行
// 需要注册才能生效
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
