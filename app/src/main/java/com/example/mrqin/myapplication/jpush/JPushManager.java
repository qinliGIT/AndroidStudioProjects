package com.example.mrqin.myapplication.jpush;

import android.content.Context;

import cn.jpush.android.api.JPushInterface;

/**
 * @data on 2018/3/15 10:22
 * @describe:
 */

public class JPushManager {
    private Context mContext;

    public JPushManager(Context context) {
        mContext = context;
    }

    /**
     * 初始化jpush
     */
    public void initJPush() {
        JPushInterface.init(mContext);
    }

    /**
     * 停止
     */
    public void stopJPush() {
        JPushInterface.stopPush(mContext);
    }

    /**
     * 继续
     */
    public void resumePush() {
        JPushInterface.resumePush(mContext);
    }


    public String getRegistrationID(){
       return JPushInterface.getRegistrationID(mContext);
    }
}
