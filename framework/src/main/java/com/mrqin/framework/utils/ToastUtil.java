package com.mrqin.framework.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * @data on 2018/3/12 16:07
 * @describe:
 */

public class ToastUtil {

    private static Toast toast;

    /**
     * 默认dialog
     * @param context
     * @param content
     */
    public static void showToast(Context context, String content) {
        if (toast == null) {
            toast = Toast.makeText(context,content,Toast.LENGTH_SHORT);
        } else {
            toast.setText(content);
        }
        toast.show();
    }


    /**
     * 自定义样式的dialog
     * @param context
     * @param strId
     * @param duration
     */
    public static void makeCustomToast(Context context, int strId, int duration) {
//        View layout = LayoutInflater.from(context).inflate(R.layout.layout_toast, null);
//        TextView toastText = (TextView) layout.findViewById(R.id.toasttext);
//        toastText.setText(context.getString(strId));
//        Toast toast = new Toast(context);
//        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
//        toast.setDuration(duration);
//        toast.setView(layout);
//        toast.show();
    }

}
