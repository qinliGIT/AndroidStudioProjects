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
import com.example.mrqin.myapplication.model.LotteryAdapterBean;
import com.example.mrqin.myapplication.model.LotteryBean;
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
 * 彩票更多开奖信息查询
 */
public class LotteryMoreAc extends BaseActivity {
    private MyHandler mHandler;
    private ImageView ll_TitleBar_back;
    private RecyclerView mRecyclerView;

    private RelativeLayout noNetLayout;
    private Button refreshBtn;

    private List<LotteryBean> mDatas = new ArrayList<>();
    private List<LotteryAdapterBean> mDataAd = new ArrayList<>();
    private LotteryAdapter mAdapter;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS", Locale.getDefault());
    private String lotteryName = "ssq";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lottery_more_layout);
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
                LotteryMoreAc.this.finish();
            }
        });

        noNetLayout = findViewById(R.id.noNetLayout);
        refreshBtn = findViewById(R.id.refreshBtn);
        refreshBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (NetworkUtil.isNetworkConnected(LotteryMoreAc.this)) {
                    noNetLayout.setVisibility(View.GONE);
                    startGetData();
                } else {
                    Snackbar.make(view, R.string.lotter_no_net, Snackbar.LENGTH_SHORT).show();
                }
            }
        });

        mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerview_lottery_more);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(LotteryMoreAc.this));

        startGetData();
    }

    private void startGetData() {
        if (NetworkUtil.getNetworkType(LotteryMoreAc.this) == 0) {
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
                final String res = new ShowApiRequest("http://route.showapi.com/44-2", appid, secret)
                        .addTextPara("code", lotteryName)
                        .addTextPara("endTime", sdf.format(new Date()))
                        .addTextPara("count", "10")
                        .post();
                System.out.println(res);
                mHandler.obtainMessage(APPID.MSG_DATA_SUCCESS_LOTTERY_FRG, res).sendToTarget();
            }
        }.start();
    }

    private void setData() {
        int length = mDatas.get(0).getShowapi_res_body().getResult().size();
        for (int i = 0; i < length; i++) {
            String title = mDatas.get(0).getShowapi_res_body().getResult().get(i).getName();
            String num = "第" + mDatas.get(0).getShowapi_res_body().getResult().get(i).getExpect() + "期";
            String time = mDatas.get(0).getShowapi_res_body().getResult().get(i).getTime();
            String code = mDatas.get(0).getShowapi_res_body().getResult().get(i).getOpenCode();
            String name = mDatas.get(0).getShowapi_res_body().getResult().get(i).getName();
            mDataAd.add(new LotteryAdapterBean(title, num, time, code, name));
        }
        mRecyclerView.setAdapter(mAdapter = new LotteryAdapter(LotteryMoreAc.this, mDataAd));
    }

    static class MyHandler extends Handler {

        private WeakReference<LotteryMoreAc> mOuter;

        private MyHandler(LotteryMoreAc outer) {
            mOuter = new WeakReference<LotteryMoreAc>(outer);
        }

        @Override
        public void handleMessage(Message msg) {
            LotteryMoreAc outer = mOuter.get();
            if (outer != null) {
                //操作
                switch (msg.what) {
                    case APPID.MSG_DATA_SUCCESS_LOTTERY_FRG:
                        Gson gson = new Gson();
                        LotteryBean lottery = gson.fromJson((String) msg.obj, LotteryBean.class);
                        outer.mDatas.clear();
                        outer.mDatas.add(lottery);
                        outer.setData();
                        break;
                }
            }
        }
    }
}
