package com.example.mrqin.myapplication.view.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mrqin.myapplication.R;
import com.example.mrqin.myapplication.adapter.RobotListAdapter;
import com.example.mrqin.myapplication.model.MsgBean;
import com.example.mrqin.myapplication.model.RobotBean;
import com.example.mrqin.myapplication.utils.APPID;
import com.google.gson.Gson;
import com.show.api.ShowApiRequest;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mrqin on 2018/3/9.
 */

public class RobotFrag extends Fragment {
    private List<RobotBean> mDatas = new ArrayList<>();

    private View view;
    private MyHandler mHandler;


    private EditText mEtMsg;
    private TextView mTvSend;

    private List<MsgBean> mMsgData = new ArrayList<MsgBean>();

    private ListView mLvMsg;
    private RobotListAdapter mRobotAdapter;

//    private RecyclerView mRecyclerView;
//    private RobotAdapter robotAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.frag_layout_robot, null);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        mRecyclerView = view.findViewById(R.id.recylerview_info);
        mEtMsg = view.findViewById(R.id.et_msg);
        mTvSend = view.findViewById(R.id.tv_send);
        mLvMsg = view.findViewById(R.id.lv_msg);

        mTvSend.setOnClickListener(mOnClickListener);

//        robotAdapter = new RobotAdapter(mRecyclerView);
//        mRecyclerView.setAdapter(robotAdapter);
//        robotAdapter.setData(mMsgData);

        //搞事情

        mRobotAdapter = new RobotListAdapter(getActivity().getApplicationContext(), R.layout.item_robot_view, mMsgData);
        mLvMsg.setAdapter(mRobotAdapter);


    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHandler = new MyHandler(this);

    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.tv_send) {
                String msg = mEtMsg.getText().toString();
                setMsg(msg);
            }
        }
    };

    private void setMsg(final String msg) {
        if (!"".equals(msg)) {
            addChatInfo(msg, MsgBean.TYPE_SEND);
            mEtMsg.setText("");
        }

        new Thread() {
            //在新线程中发送网络请求
            public void run() {
                String appid = APPID.TURING_ID;//要替换成自己的
                String secret = APPID.TURING_SCREAT;//要替换成自己的
                final String res = new ShowApiRequest("http://route.showapi.com/60-27", appid, secret)
                        .addTextPara("info", msg)
                        .addTextPara("userid", "userid")
                        .post();
                System.out.println(res);
                mHandler.obtainMessage(APPID.MSG_DATA_SUCCESS_LOTTERY_FRG, res).sendToTarget();
            }
        }.start();
    }

    static class MyHandler extends Handler {
        // WeakReference to the outer class's instance.
        private WeakReference<RobotFrag> mOuter;

        private MyHandler(RobotFrag outer) {
            mOuter = new WeakReference<RobotFrag>(outer);
        }

        @Override
        public void handleMessage(Message msg) {
            RobotFrag outer = mOuter.get();
            if (outer != null) {
                //操作
                switch (msg.what) {
                    case APPID.MSG_DATA_SUCCESS_LOTTERY_FRG:
                        Gson gson = new Gson();
                        RobotBean robot = gson.fromJson((String) msg.obj, RobotBean.class);
                        outer.mDatas.clear();
                        outer.mDatas.add(robot);
                        outer.setData();
                        break;
                }
            }
        }
    }

    /**
     * 设置数据
     */
    private void setData() {
        String msg = mDatas.get(0).getShowapi_res_body().getText();
        addChatInfo(msg, MsgBean.TYPE_RECEIVED);

    }

    /**
     * 添加聊天数据
     *
     * @param msg
     * @param type
     */
    private void addChatInfo(String msg, int type) {
        MsgBean bean = new MsgBean(msg, type);
        mMsgData.add(bean);
        mRobotAdapter.notifyDataSetChanged();
        mLvMsg.setSelection(mMsgData.size());
    }
}
