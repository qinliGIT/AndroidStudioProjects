package com.example.mrqin.myapplication.view.logo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mrqin.myapplication.MainActivity;
import com.example.mrqin.myapplication.R;
import com.example.mrqin.myapplication.model.LotteryBean;
import com.example.mrqin.myapplication.model.MainUrlBean;
import com.example.mrqin.myapplication.utils.APPID;
import com.example.mrqin.myapplication.utils.OkhttpUtils;
import com.example.mrqin.myapplication.view.BaseActivity;
import com.example.mrqin.myapplication.view.MyWebView;
import com.google.gson.Gson;


/**
 * 启动页面
 */
public class AcLogo extends BaseActivity {
    private ImageView background;
    private static Activity ac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);// 隐藏标题
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);// 设置全屏

        setContentView(R.layout.ac_logo);
        ac = this;
        init();
    }

    private void init() {
        OkhttpUtils.getInstance().Get(APPID.url, new OkhttpUtils.ResultCallBackListener() {
            @Override
            public void noNetWork() {

            }

            @Override
            public void onLoadingShow() {

            }

            @Override
            public void onLoadingDismiss() {

            }

            @Override
            public void onSuccess(String requestname, String result_str) {
                String json = result_str;
//成功就解析数据
                /**
                 * appid : 911580001
                 * appname : 小亮安卓
                 * isshowwap : 1
                 * wapurl : https://apk.update-daquan369app.com/
                 * status : 1
                 * desc : 成功返回数据
                 */
                Gson gson = new Gson();
                MainUrlBean url = gson.fromJson(json, MainUrlBean.class);
                if (url.getStatus() == 1 && json != null && !json.equalsIgnoreCase("")) {
                    if (url.getIsshowwap() != null && !url.getIsshowwap().equalsIgnoreCase("") && url.getIsshowwap().equalsIgnoreCase("1")) {
                        if (url.getWapurl() != null && !url.getWapurl().equalsIgnoreCase("")) {
                            MyWebView.open(AcLogo.this, url.getWapurl());
                            AcLogo.this.finish();
                        } else {
                            startThread();
                        }
                    } else {
                        startThread();
                    }
                } else {
                    startThread();
                }
            }

            @Override
            public void onFailure(String requestname, Exception e) {

            }

            @Override
            public void onError(String requestname, String result_str) {
                Toast.makeText(AcLogo.this, result_str, Toast.LENGTH_SHORT).show();
                startThread();
            }
        });
    }

    private void startThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                handler.sendEmptyMessage(1);
            }
        }).start();
    }


    private MyHandler handler = new MyHandler(this);

    private static class MyHandler extends Handler {

        private Activity activity;

        public MyHandler(Activity activity) {
            this.activity = activity;
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (AcLeadPage.isShow(activity)) {
                Intent intent = new Intent(activity, AcLeadPage.class);
                activity.startActivity(intent);
                activity.finish();
            } else {
                Intent intent = new Intent(activity, MainActivity.class);
                activity.startActivity(intent);
                activity.finish();
            }
        }
    }

    ;

}
