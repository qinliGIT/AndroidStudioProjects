package com.example.mrqin.myapplication.app;

import android.app.Application;

import com.mrqin.jpush.Logger;

import cn.jpush.android.api.JPushInterface;

/**
 * @data on 2018/3/15 10:13
 * @describe:
 */

public class MyApp extends Application{
    private static final String TAG = "MyApp";

    @Override
    public void onCreate() {
        Logger.d(TAG, "[Application] onCreate");
        super.onCreate();

        JPushInterface.setDebugMode(true); 	// 设置开启日志,发布时请关闭日志
        JPushInterface.init(this);     		// 初始化 JPush
    }
}
