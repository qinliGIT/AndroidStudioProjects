package com.example.mrqin.myapplication.view.lottery;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.mrqin.myapplication.R;
import com.example.mrqin.myapplication.adapter.LotteryAdapter;
import com.example.mrqin.myapplication.adapter.LuckAdapter;
import com.example.mrqin.myapplication.model.LotteryAdapterBean;
import com.example.mrqin.myapplication.model.LotteryBean;
import com.example.mrqin.myapplication.model.LuckBean;
import com.example.mrqin.myapplication.utils.APPID;
import com.example.mrqin.myapplication.utils.NetworkUtil;
import com.example.mrqin.myapplication.view.BaseActivity;
import com.google.gson.Gson;
import com.show.api.ShowApiRequest;

import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;


/**
 * 运势详情页面
 */
public class LuckMoreAc extends BaseActivity {
    private MyHandler mHandler;
    private ImageView ll_TitleBar_back;
    private RecyclerView mRecyclerView;

    private RelativeLayout noNetLayout;
    private Button refreshBtn;

    private static LuckBean luckBean;
    private static List<LuckBean.ShowapiResBodyBean.DayBean> mList = new ArrayList<>();;
    private LuckAdapter mAdapter;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS", Locale.getDefault());
    private String lotteryName = "ssq";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.luck_more_layout);
        lotteryName = getIntent().getStringExtra("name");
        if (lotteryName == null) {
            lotteryName = "ssq";
        }
        init();
    }

    private void init() {
        mHandler = new MyHandler(this);
        ll_TitleBar_back = (ImageView) findViewById(R.id.ll_TitleBar_back);
        ll_TitleBar_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LuckMoreAc.this.finish();
            }
        });

        noNetLayout = findViewById(R.id.noNetLayout);
        refreshBtn = findViewById(R.id.refreshBtn);
        refreshBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (NetworkUtil.isNetworkConnected(LuckMoreAc.this)) {
                    noNetLayout.setVisibility(View.GONE);
                    startGetData();
                } else {
                    Snackbar.make(view, R.string.lotter_no_net, Snackbar.LENGTH_SHORT).show();
                }
            }
        });

        mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerview_luck_more);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(LuckMoreAc.this));

        startGetData();
    }

    private void startGetData() {
        if (NetworkUtil.getNetworkType(LuckMoreAc.this) == 0) {
            noNetLayout.setVisibility(View.VISIBLE);
        } else {
            startThread();
        }
    }

    private void startThread() {
        new Thread() {
            //在新线程中发送网络请求
            public void run() {
                String appid = APPID.APP_ID;//要替换成自己的
                String secret = APPID.APP_SCREAT;//要替换成自己的
                final String res = new ShowApiRequest("http://route.showapi.com/872-1", appid, secret)
                        .addTextPara("star", "shizi")
                        .addTextPara("needTomorrow", "1")
                        .addTextPara("needWeek", "1")
                        .addTextPara("needMonth", "1")
                        .addTextPara("needYear", "1")
                        .post();
                System.out.println(res);
                mHandler.obtainMessage(APPID.MSG_DATA_SUCCESS_LOTTERY_FRG, res).sendToTarget();
            }
        }.start();
    }

    private void setData() {

        mRecyclerView.setAdapter(mAdapter = new LuckAdapter(LuckMoreAc.this, luckBean));
    }

    static class MyHandler extends Handler {

        private WeakReference<LuckMoreAc> mOuter;

        private MyHandler(LuckMoreAc outer) {
            mOuter = new WeakReference<LuckMoreAc>(outer);
        }

        @Override
        public void handleMessage(Message msg) {
            LuckMoreAc outer = mOuter.get();
            if (outer != null) {
                //操作
                switch (msg.what) {
                    case APPID.MSG_DATA_SUCCESS_LOTTERY_FRG:
                        Gson gson = new Gson();
                        luckBean = gson.fromJson((String) msg.obj, LuckBean.class);
                        mList.clear();
                        mList.add(luckBean.getShowapi_res_body().getDay());
//                        LuckBean.ShowapiResBodyBean.DayBean b = luckBean.getShowapi_res_body().getTomorrow();
//                        mList.add(luckBean.getShowapi_res_body().getTomorrow());
                        outer.setData();
                        break;
                }
            }
        }
    }

//    private LuckBean.ShowapiResBodyBean.DayBean getBean(){
//
//    };
}
