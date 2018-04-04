package com.example.mrqin.myapplication.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.zhy.http.okhttp.OkHttpUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Mrqin on 2018/3/16.
 */

public class OkhttpUtils {
    private static final String BASE_URL = "";

    /**
     * 网络访问要求singleton
     */
    private static OkhttpUtils instance;

    // 必须要用的okhttpclient实例,在构造器中实例化保证单一实例
    private OkHttpClient mOkHttpClient;

    public static final MediaType JSON = MediaType.
            parse("application/json; charset=utf-8");

    private Handler mHandler;

    private OkhttpUtils() {
        /**
         * okHttp3中超时方法移植到Builder中
         */
        mOkHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build();

        mHandler = new Handler(Looper.getMainLooper());
    }

    public static OkhttpUtils getInstance() {
        if (instance == null) {
            synchronized (OkhttpUtils.class) {
                if (instance == null) {
                    instance = new OkhttpUtils();
                }
            }
        }
        return instance;
    }

    /**
     * 对外提供的Get方法访问
     *
     * @param requestname
     * @param listener
     */
    public void Get(String requestname, ResultCallBackListener listener) {

        /**
         * 通过url和GET方式构建Request
         */
        Request request = bulidRequestForGet(BASE_URL + requestname);
        /**
         * 请求网络的逻辑
         */
        requestNetWork(requestname, request, listener);
    }

    /**
     * 对外提供的Post方法访问
     *
     * @param requestname
     * @param body:       提交内容为表单数据
     * @param listener
     */
    public void PostWithFormData(String requestname, FormBody.Builder body, ResultCallBackListener listener) {
        /**
         * 通过url和POST方式构建Request
         */
        Request request = bulidRequestForPostByForm(BASE_URL + requestname, body);
        /**
         * 请求网络的逻辑
         */
        requestNetWork(requestname, request, listener);

    }

    /**
     * 对外提供的Post方法访问
     *
     * @param requestname
     * @param json:       提交内容为json数据
     * @param listener
     */
    public void PostWithJson(String requestname, String json, ResultCallBackListener listener) {
        /**
         * 通过url和POST方式构建Request
         */
        Request request = bulidRequestForPostByJson(BASE_URL + requestname, json);
        /**
         * 请求网络的逻辑
         */
        requestNetWork(requestname, request, listener);

    }

    /**
     * 对外提供的Post方法访问
     *
     * @param requestname
     * @param body        提交内容为文件数据
     * @param listener
     */
    public void PostWithFile(final String requestname, MultipartBody.Builder body, ResultCallBackListener listener) {
        /**
         * 通过url和POST方式构建Request
         */
        Request request = bulidRequestForPostByFile(BASE_URL + requestname, body);
        /**
         * 请求网络的逻辑
         */
        requestNetWork(requestname, request, listener);
    }

    /**
     * POST方式构建Request {File}
     *
     * @param url
     * @param body
     * @return
     */
    private Request bulidRequestForPostByFile(String url, MultipartBody.Builder body) {
        RequestBody requestBody = body.build();

        return new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
    }

    /**
     * POST方式构建Request {json}
     *
     * @param url
     * @param json
     * @return
     */
    private Request bulidRequestForPostByJson(String url, String json) {
        RequestBody body = RequestBody.create(JSON, json);

        return new Request.Builder()
                .url(url)
                .post(body)
                .build();
    }

    /**
     * POST方式构建Request {Form}
     *
     * @param url
     * @param body
     * @return
     */
    private Request bulidRequestForPostByForm(String url, FormBody.Builder body) {
        RequestBody requestBody = body.build();
        return new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
    }

    /**
     * GET方式构建Request
     *
     * @param url
     * @return
     */
    private Request bulidRequestForGet(String url) {

        return new Request.Builder()
                .url(url)
                .get()
                .build();
    }


    private void requestNetWork(final String requestname, final Request request, final ResultCallBackListener listener) {
        /**
         * 判断网络是否连接
         */
//        if (!NetworkUtil.isConnected()) {
//            listener.noNetWork();
//            return;
//        }
        /**
         * 加载前
         */
        listener.onLoadingShow();

        /**
         * 处理连网逻辑，此处只处理异步操作enqueue
         */
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                //使用handler返回UI线程
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        listener.onFailure(requestname, e);
                        /**
                         * 数据加载后
                         */
                        listener.onLoadingDismiss();
                    }
                });

            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                final String result_str = response.body().string();

                //使用handler返回UI线程
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (response.isSuccessful()) {
                            listener.onSuccess(requestname, result_str);
                        } else {
                            listener.onError(requestname, result_str);
                        }
                        /**
                         * 数据加载后
                         */
                        listener.onLoadingDismiss();
                    }
                });
            }
        });

    }

    public interface ResultCallBackListener {
        void noNetWork();

        void onLoadingShow();

        void onLoadingDismiss();

        void onSuccess(String requestname, String result_str);

        void onFailure(String requestname, Exception e);

        void onError(String requestname, String result_str);
    }
}
