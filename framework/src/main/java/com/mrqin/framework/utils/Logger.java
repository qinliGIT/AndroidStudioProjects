package com.mrqin.framework.utils;

import android.util.Log;

import com.mrqin.framework.BuildConfig;

/**
 * @data on 2018/3/9 12:01
 * @describe:
 */

public class Logger {
    public static int LOG_LEVEL  =6;
    public static int VERBOSE  = 5;
    public static int DEBUG  = 4;
    public static int INFO  = 3;
    public static int WARN  = 2;
    public static int ERROR  = 1;

    public static void v(String tag,String msg){
        if(LOG_LEVEL>VERBOSE&& BuildConfig.isDebug){
            Log.v(tag, msg);
        }
    }

    public static void d(String tag,String msg){
        if(LOG_LEVEL>DEBUG&& BuildConfig.isDebug){
            Log.d(tag, msg);
        }
    }
    public static void i(String tag,String msg){
        if(LOG_LEVEL>INFO&& BuildConfig.isDebug){
            Log.i(tag, msg);
        }
    }
    public static void w(String tag,String msg){
        if(LOG_LEVEL>WARN&& BuildConfig.isDebug){
            Log.w(tag, msg);
        }
    }
    public static void e(String tag,String msg){
        if(LOG_LEVEL>ERROR&& BuildConfig.isDebug){
            Log.e(tag, msg);
        }
    }
}
