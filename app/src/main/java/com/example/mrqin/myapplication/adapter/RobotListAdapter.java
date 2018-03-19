package com.example.mrqin.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mrqin.myapplication.R;
import com.example.mrqin.myapplication.model.MsgBean;

import java.util.List;

/**
 * @data on 2018/3/16 9:38
 * @describe:
 */

public class RobotListAdapter extends ArrayAdapter<MsgBean> {
    private int resourceId;

    public RobotListAdapter(Context context, int textViewResourceId, List<MsgBean> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        MsgBean msg = getItem(position);
        View view;
        ViewHolder viewHolder;
        if(convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, null);
            viewHolder = new ViewHolder();
            viewHolder.leftLayout = (LinearLayout)view.findViewById(R.id.left_layout);
            viewHolder.rightLayout = (LinearLayout)view.findViewById(R.id.right_layout);
            viewHolder.leftMsg = (TextView)view.findViewById(R.id.left_msg);
            viewHolder.rightMsg = (TextView)view.findViewById(R.id.right_msg);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        if(msg.getType() == MsgBean.TYPE_RECEIVED) {
            viewHolder.leftLayout.setVisibility(View.VISIBLE);
            viewHolder.rightLayout.setVisibility(View.GONE);
            viewHolder.leftMsg.setText(msg.getContent());
        } else if(msg.getType() == MsgBean.TYPE_SEND) {
            viewHolder.rightLayout.setVisibility(View.VISIBLE);
            viewHolder.leftLayout.setVisibility(View.GONE);
            viewHolder.rightMsg.setText(msg.getContent());
        }
        return view;
    }

    class ViewHolder {
        LinearLayout leftLayout;
        LinearLayout rightLayout;
        TextView leftMsg;
        TextView rightMsg;
    }
}
