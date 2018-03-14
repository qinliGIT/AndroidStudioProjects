package com.example.mrqin.myapplication.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.mrqin.myapplication.R;

/**
 * Created by Mrqin on 2018/3/14.
 */

public class MyWebView extends BaseActivity {
    private WebView webView;
    private String url;

    public static void open(Context context, String title, String url) {
        Intent intent = new Intent(context, MyWebView.class);
        intent.putExtra("title", title);
        intent.putExtra("url", url);
        context.startActivity(intent);
    }

    public static void open(Context context, String url) {
        open(context, null, url);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview_layout);
        url = getIntent().getStringExtra("url");

        init();
    }

    private void init() {
        webView = findViewById(R.id.lottery_web);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);// 开启 DOM storage API 功能
        settings.setCacheMode(WebSettings.LOAD_DEFAULT);// 设置 缓存模式
        settings.setAppCacheEnabled(true);// 启动缓存


        Intent intent = getIntent();
        if (intent != null) {
            String dataString = intent.getDataString();
            if (dataString != null && dataString.length() > 0) {
                url = dataString;
            }
        }

        if (url != null && url.length() > 0) {
            webView.loadUrl(url);
        }

    }
}
