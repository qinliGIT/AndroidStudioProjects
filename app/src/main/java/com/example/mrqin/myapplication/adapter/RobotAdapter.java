package com.example.mrqin.myapplication.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mrqin.myapplication.R;
import com.example.mrqin.myapplication.model.MsgBean;

import cn.bingoogolapple.androidcommon.adapter.BGARecyclerViewAdapter;
import cn.bingoogolapple.androidcommon.adapter.BGAViewHolderHelper;

/**
 * @data on 2018/3/15 9:56
 * @describe:
 */

public class RobotAdapter extends BGARecyclerViewAdapter<MsgBean> {

    public RobotAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.item_robot_view);
    }

    @Override
    protected void fillData(BGAViewHolderHelper helper, int position, MsgBean model) {
        LinearLayout leftLayout = helper.getView(R.id.left_layout);
        LinearLayout rightLayout = helper.getView(R.id.right_layout);
        TextView leftMsg = helper.getTextView(R.id.left_msg);
        TextView rightMsg = helper.getTextView(R.id.right_msg);
        if (model.getType() == MsgBean.TYPE_RECEIVED){
            leftLayout.setVisibility(View.VISIBLE);
            rightLayout.setVisibility(View.GONE);
            leftMsg.setText(model.getContent());
        }else if (model.getType() == MsgBean.TYPE_SEND){
            rightLayout.setVisibility(View.VISIBLE);
            leftLayout.setVisibility(View.GONE);
            rightMsg.setText(model.getContent());
        }
    }


}
