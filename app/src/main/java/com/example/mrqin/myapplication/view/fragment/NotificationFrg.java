package com.example.mrqin.myapplication.view.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mrqin.myapplication.R;
import com.example.mrqin.myapplication.adapter.NotifyAdapter;
import com.example.mrqin.myapplication.model.LotteryBean;
import com.example.mrqin.myapplication.utils.APPID;
import com.example.mrqin.myapplication.utils.NetworkUtil;
import com.example.mrqin.myapplication.utils.OkhttpUtils;
import com.google.gson.Gson;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Leo on 2018/4/4.
 */

public class NotificationFrg extends Fragment {

    final String CSDNURL = "http://www.csdn.net/";
    String csdnString = "";

    private View view;
    private RecyclerView mRecyclerView;
    private RelativeLayout noNetLayout;
    private Button refreshBtn;

    private MyHandler mHandler;
    List<String> data;

    NotifyAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_layout_notification, null);
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
        mRecyclerView = view.findViewById(R.id.noptify_id_recyclerview);
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
                Message msg = new Message();
                try {
                    data = getCsdnNetDate();
                    msg.what = APPID.MSG_DATA_SUCCESS_NOTIFY_FRG;
                } catch (Exception e) {
                    e.printStackTrace();
                    msg.what = -1;
                }
                mHandler.obtainMessage(msg.what, data).sendToTarget();
            }
        }.start();
    }


    /**
     * 联网获得数据
     *
     * @return 数据
     * @author Lai Huan
     * @created 2013-6-20
     */
    private List<String> getCsdnNetDate() {
        List<String> result = new ArrayList<String>();
        OkhttpUtils.getInstance().Get(CSDNURL, new OkhttpUtils.ResultCallBackListener() {
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
                Snackbar.make(view, result_str, Snackbar.LENGTH_LONG).show();
                csdnString = result_str;
            }

            @Override
            public void onFailure(String requestname, Exception e) {

            }

            @Override
            public void onError(String requestname, String result_str) {

            }
        });
//        String csdnString = http_get(CSDNURL);
        //<li><a title="(.*?)" href="(.*?)" target="_blank" onclick="LogClickCountthis,363;">\1</a></li>
        //title="(.*?)" href="(.*?)".*?,363\)
        Pattern p = Pattern.compile("class=\"(.*?)\" href=\"(.*?)\".*?target=\"_blank\"");
        Matcher m = p.matcher(csdnString);
        while (m.find()) {
            MatchResult mr = m.toMatchResult();
//            Map<String, Object> map = new HashMap<String, Object>();
//            map.put("title", mr.group(1));
//            map.put("url", mr.group(2));
            result.add(mr.group(1));
        }
        return result;
    }


    static class MyHandler extends Handler {
        // WeakReference to the outer class's instance.
        private WeakReference<NotificationFrg> mOuter;

        private MyHandler(NotificationFrg outer) {
            mOuter = new WeakReference<NotificationFrg>(outer);
        }

        @Override
        public void handleMessage(Message msg) {
            NotificationFrg outer = mOuter.get();
            if (outer != null) {
                //操作
                switch (msg.what) {
                    case APPID.MSG_DATA_SUCCESS_NOTIFY_FRG:
                        String[] strs = null;
                        for (int i = 0; i < outer.data.size(); i++) {
                            strs[i] = outer.data.get(i);
                        }

                        outer.adapter = new NotifyAdapter(outer.getActivity(), strs);
                        break;
                }
            }
        }
    }


}