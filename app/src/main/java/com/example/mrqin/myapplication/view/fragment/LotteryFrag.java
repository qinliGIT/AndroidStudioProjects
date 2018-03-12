package com.example.mrqin.myapplication.view.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mrqin.myapplication.R;
import com.example.mrqin.myapplication.model.LotteryBean;
import com.example.mrqin.myapplication.utils.TextViewUtils;
import com.google.gson.Gson;
import com.show.api.ShowApiRequest;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mrqin on 2018/3/9.
 */

public class LotteryFrag extends Fragment {
    private String APP_ID = "58707";
    private String APP_SCREAT = "361a7423700f4e129fd78a08de40d6cb";
    /*获取网络数据*/
    private static final int MSG_DATA_SUCCESS = 0X001;
    private View view;
    private MyHandler mHandler;

    private RecyclerView mRecyclerView;
    private List<LotteryBean> mDatas = new ArrayList<>();
    private LotteryAdapter mAdapter;

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
        mRecyclerView = (RecyclerView) view.findViewById(R.id.id_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        new Thread() {
            //在新线程中发送网络请求
            public void run() {
                String appid = APP_ID;//要替换成自己的
                String secret = APP_SCREAT;//要替换成自己的
                final String res = new ShowApiRequest("http://route.showapi.com/44-1", appid, secret)
                        .addTextPara("code", "ssq|dlt|fc3d|pl3|pl5|qxc|qlc")
                        .post();
                System.out.println(res);
                mHandler.obtainMessage(MSG_DATA_SUCCESS, res).sendToTarget();
            }
        }.start();
    }

    private void setData() {
        mRecyclerView.setAdapter(mAdapter = new LotteryAdapter());
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
                    case MSG_DATA_SUCCESS:
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

    class LotteryAdapter extends RecyclerView.Adapter<LotteryAdapter.MyViewHolder> {

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                    getActivity()).inflate(R.layout.lottery_frag_adapter_layout, parent,
                    false));
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.lottery_title.setText(mDatas.get(0).getShowapi_res_body().getResult().get(position).getName());
            holder.lottery_num.setText("第" + mDatas.get(0).getShowapi_res_body().getResult().get(position).getExpect() + "期");
            holder.lottery_time.setText(mDatas.get(0).getShowapi_res_body().getResult().get(position).getTime());
            String lotteryRes = mDatas.get(0).getShowapi_res_body().getResult().get(position).getOpenCode();
            String[] redLotteryNums = null;
            String[] blueLotteryNums = null;
            if (lotteryRes.contains("+")) {
                String[] leftRed = lotteryRes.split("\\+");
                redLotteryNums = leftRed[0].split(",");
                blueLotteryNums = leftRed[1].split(",");
            } else {
                redLotteryNums = lotteryRes.split(",");
            }
            for (int i = 0; i < redLotteryNums.length; i++) {
                TextView circleTextView = getTextView(redLotteryNums,i,true);
                holder.lottery_layout.addView(circleTextView);
            }
            if (blueLotteryNums != null) {
                for (int i = 0; i < blueLotteryNums.length; i++) {
                    TextView circleTextView = getTextView(blueLotteryNums,i,false);
                    holder.lottery_layout.addView(circleTextView);
                }
            }
        }

        private TextView getTextView(String[] lotteryNums, int i, boolean isRed) {
            TextView circleTextView = new TextView(getActivity());
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(TextViewUtils.dip2px(getActivity(), 32), TextViewUtils.dip2px(getActivity(), 32));
            lp.setMargins(8, 0, 8, 0);
            circleTextView.setLayoutParams(lp);
            circleTextView.setGravity(Gravity.CENTER);
            circleTextView.setPadding(16, 16, 16, 16);
            circleTextView.setTextColor(getResources().getColor(R.color.text_white));
            circleTextView.setBackground(isRed ? getResources().getDrawable(R.drawable.circle_lottery_shape_red) : getResources().getDrawable(R.drawable.circle_lottery_shape_blue));
            circleTextView.setText(lotteryNums[i]);
            return circleTextView;
        }

        @Override
        public int getItemCount() {
            return mDatas.get(0).getShowapi_res_body().getResult().size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {

            TextView lottery_title, lottery_num, lottery_time;
            LinearLayout lottery_layout;

            public MyViewHolder(View view) {
                super(view);
                lottery_title = view.findViewById(R.id.lotter_item_title);
                lottery_num = view.findViewById(R.id.lotter_item_num);
                lottery_time = view.findViewById(R.id.lotter_item_time);
                lottery_layout = view.findViewById(R.id.lottery_layout);
            }
        }
    }
}
