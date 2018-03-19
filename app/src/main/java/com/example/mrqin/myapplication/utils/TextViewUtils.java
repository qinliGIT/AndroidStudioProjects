package com.example.mrqin.myapplication.utils;

import android.content.Context;

/**
 * Created by Mrqin on 2018/3/11.
 */

public class TextViewUtils {
    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 根据数组position获取星座
     *
     * @param position
     * @return
     */
    public static String getStar(int position) {
        String star = "baiyang";
        switch (position) {
            case 0:
                star = "baiyang";
                break;
            case 1:
                star = "jinniu";
                break;
            case 2:
                star = "shuangzi";
                break;
            case 3:
                star = "juxie";
                break;
            case 4:
                star = "shizi";
                break;
            case 5:
                star = "chunv";
                break;
            case 6:
                star = "tiancheng";
                break;
            case 7:
                star = "tianxie";
                break;
            case 8:
                star = "sheshou";
                break;
            case 9:
                star = "mojie";
                break;
            case 10:
                star = "shuiping";
                break;
            case 11:
                star = "shuangyu";
                break;
        }
        return star;
    }
}
