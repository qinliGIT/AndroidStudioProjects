package com.example.mrqin.myapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mrqin.myapplication.R;
import com.example.mrqin.myapplication.model.LotteryAdapterBean;
import com.example.mrqin.myapplication.utils.TextViewUtils;

import java.util.List;

/**
 * Created by Mrqin on 2018/3/14.
 */

public class NotifyAdapter extends RecyclerView.Adapter<NotifyAdapter.MyViewHolder> {
    private MyItemClickListener mItemClickListener;
    private Context mContext;
    private String [] mStrings;

    public NotifyAdapter(Context context, String [] mStrings) {
        this.mContext = context;
        this.mStrings = mStrings;
    }

    @Override

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(mContext, R.layout.notify_adapter_item_layout, null);
        //将全局的监听传递给holder
        MyViewHolder holder = new MyViewHolder(view, mItemClickListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.setIsRecyclable(false);
        //给空间赋值
        holder.notify_title.setText(mStrings[position]);
//        holder.notify_img.setText(mList.get(position).getNum());
    }

    @Override
    public int getItemCount() {
        return mStrings.length;
    }


    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private MyItemClickListener mListener;
        private TextView notify_title;
        private ImageView notify_img;

        public MyViewHolder(View itemView, MyItemClickListener myItemClickListener) {
            super(itemView);
            //将全局的监听赋值给接口
            notify_img = itemView.findViewById(R.id.img_notify);
            notify_title = itemView.findViewById(R.id.txt_notify);
            mListener = myItemClickListener;
            itemView.setOnClickListener(this);
        }


        /**
         * 实现OnClickListener接口重写的方法
         *
         * @param v
         */
        @Override
        public void onClick(View v) {
            if (mListener != null) {
                mListener.onItemClick(v, getPosition());
            }

        }
    }

    /**
     * 创建一个回调接口
     */
    public interface MyItemClickListener {
        void onItemClick(View view, int position);
    }

    /**
     * 在activity里面adapter就是调用的这个方法,将点击事件监听传递过来,并赋值给全局的监听
     *
     * @param myItemClickListener
     */
    public void setItemClickListener(MyItemClickListener myItemClickListener) {
        this.mItemClickListener = myItemClickListener;
    }
}