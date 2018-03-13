package com.example.mrqin.myapplication.view.logo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.mrqin.myapplication.MainActivity;
import com.example.mrqin.myapplication.R;
import com.example.mrqin.myapplication.view.BaseActivity;


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
