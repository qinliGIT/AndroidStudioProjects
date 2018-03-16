package com.example.mrqin.myapplication.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

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

        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setUseWideViewPort(true);//设置webview推荐使用的窗口
        settings.setLoadWithOverviewMode(true);//设置webview加载的页面的模式
        settings.setDisplayZoomControls(false);//隐藏webview缩放按钮
        settings.setAllowFileAccess(true); // 允许访问文件
        settings.setBuiltInZoomControls(true); // 设置显示缩放按钮
        settings.setSupportZoom(true); // 支持缩放

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

        //覆盖WebView默认使用第三方或系统默认浏览器打开网页的行为，使网页用WebView打开
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                if (url.startsWith("https://down")) {

                } else {
                    view.loadUrl(url);
                }
                return true;
            }
        });
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (webView.canGoBack()) {
                webView.goBack();//返回上一页面
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

}
