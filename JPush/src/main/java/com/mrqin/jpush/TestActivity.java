package com.mrqin.jpush;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import cn.jpush.android.api.JPushInterface;

public class TestActivity extends Activity {

    private TextView mTvTitle;
    private TextView mTvContent;

    private String url = "www.baidu.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_text);
        mTvTitle = findViewById(R.id.tv_title);
        mTvContent = findViewById(R.id.tv_content);

        mTvTitle.setText(getResources().getString(R.string.app_name));

        Intent intent = getIntent();
        if (null != intent) {
            Bundle bundle = getIntent().getExtras();
            String title = null;
            String content = null;
            if (bundle != null) {
                title = bundle.getString(JPushInterface.EXTRA_NOTIFICATION_TITLE);
                content = bundle.getString(JPushInterface.EXTRA_ALERT);
            }
            url = content;
            mTvContent.setText(content);
        }


    }

    public void back(View view) {
        finish();
    }

    public void enter(View view) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        Uri content_url = Uri.parse(url);
        intent.setData(content_url);
        startActivity(intent);
    }

}
