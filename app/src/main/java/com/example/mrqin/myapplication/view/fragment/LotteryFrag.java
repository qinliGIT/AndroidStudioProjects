package com.example.mrqin.myapplication.view.fragment;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mrqin.myapplication.R;
import com.example.mrqin.myapplication.adapter.LotteryAdapter;
import com.example.mrqin.myapplication.model.LotteryAdapterBean;
import com.example.mrqin.myapplication.model.LotteryBean;
import com.example.mrqin.myapplication.utils.APPID;
import com.example.mrqin.myapplication.utils.NetworkUtil;
import com.example.mrqin.myapplication.utils.TextViewUtils;
import com.example.mrqin.myapplication.view.lottery.LotteryMoreAc;
import com.google.gson.Gson;
import com.show.api.ShowApiRequest;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mrqin on 2018/3/9.
 */

public class LotteryFrag extends Fragment {
    private View view;
    private MyHandler mHandler;

    private RecyclerView mRecyclerView;
    private List<LotteryBean> mDatas = new ArrayList<>();
    private List<LotteryAdapterBean> mDataAd = new ArrayList<>();
    private LotteryAdapter mAdapter;

    private RelativeLayout noNetLayout;
    private Button refreshBtn;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_layout_lottery, null);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mHandler = new MyHandler(this);
        noNetLayout = view.findViewById(R.id.noNetLayout);
        refreshBtn = view.findViewById(R.id.refreshBtn);
        refreshBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (NetworkUtil.isNetworkConnected(getActivity())) {
                    noNetLayout.setVisibility(View.GONE);
                    startGetData();
                } else {
                    Snackbar.make(view, R.string.lotter_no_net, Snackbar.LENGTH_SHORT).show();
                }
            }
        });
        mRecyclerView = view.findViewById(R.id.id_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        startGetData();
    }

    private void startGetData() {
        if (NetworkUtil.getNetworkType(getActivity()) == 0) {
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
                final String res = new ShowApiRequest("http://route.showapi.com/44-1", appid, secret)
                        .addTextPara("code", "ssq|dlt|fc3d|pl3|pl5|qxc|qlc")
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
            String name = mDatas.get(0).getShowapi_res_body().getResult().get(i).getCode();
            mDataAd.add(new LotteryAdapterBean(title, num, time, code, name));
        }
        mRecyclerView.setAdapter(mAdapter = new LotteryAdapter(getActivity(), mDataAd));

        //调用方法,传入一个接口回调
        mAdapter.setItemClickListener(new LotteryAdapter.MyItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                LotteryAdapterBean bean = mDataAd.get(position);
                Intent in = new Intent(getActivity(), LotteryMoreAc.class);
                in.putExtra("name", bean.getName());
                if (android.os.Build.VERSION.SDK_INT > 20) {
                    startActivity(in, ActivityOptions.makeSceneTransitionAnimation(getActivity(), mRecyclerView, "transitionImg").toBundle());
                } else {
                    startActivity(in);
                }
            }
        });

    }

    static class MyHandler extends Handler {
        // WeakReference to the outer class's instance.
        private WeakReference<LotteryFrag> mOuter;

        private MyHandler(LotteryFrag outer) {
            mOuter = new WeakReference<LotteryFrag>(outer);
        }

        @Override
        public void handleMessage(Message msg) {
            LotteryFrag outer = mOuter.get();
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
