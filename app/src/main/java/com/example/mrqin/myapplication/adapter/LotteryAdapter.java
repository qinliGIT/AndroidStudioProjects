package com.example.mrqin.myapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mrqin.myapplication.R;
import com.example.mrqin.myapplication.model.LotteryAdapterBean;
import com.example.mrqin.myapplication.utils.TextViewUtils;

import java.util.List;

/**
 * Created by Mrqin on 2018/3/14.
 */

public class LotteryAdapter extends RecyclerView.Adapter<LotteryAdapter.MyViewHolder> {
    private MyItemClickListener mItemClickListener;
    private Context mContext;
    private List<LotteryAdapterBean> mList;

    public LotteryAdapter(Context context, List<LotteryAdapterBean> list) {
        this.mContext = context;
        this.mList = list;
    }

    @Override

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(mContext, R.layout.lottery_frag_adapter_layout, null);
        //将全局的监听传递给holder
        MyViewHolder holder = new MyViewHolder(view, mItemClickListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.setIsRecyclable(false);
        //给空间赋值
        holder.lottery_title.setText(mList.get(position).getTitle());
        holder.lottery_num.setText(mList.get(position).getNum());
        holder.lottery_time.setText(mList.get(position).getTime());
        String lotteryRes = mList.get(position).getCode();
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
            TextView circleTextView = getTextView(redLotteryNums, i, true);
            holder.lottery_layout.addView(circleTextView);
        }
        if (blueLotteryNums != null) {
            for (int i = 0; i < blueLotteryNums.length; i++) {
                TextView circleTextView = getTextView(blueLotteryNums, i, false);
                holder.lottery_layout.addView(circleTextView);
            }
        }
    }

    private TextView getTextView(String[] lotteryNums, int i, boolean isRed) {
        TextView circleTextView = new TextView(mContext);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(TextViewUtils.dip2px(mContext, 32), TextViewUtils.dip2px(mContext, 32));
        lp.setMargins(8, 0, 8, 0);
        circleTextView.setLayoutParams(lp);
        circleTextView.setGravity(Gravity.CENTER);
        circleTextView.setPadding(16, 16, 16, 16);
        circleTextView.setTextColor(mContext.getResources().getColor(R.color.text_white));
        circleTextView.setBackground(isRed ? mContext.getResources().getDrawable(R.drawable.circle_lottery_shape_red) : mContext.getResources().getDrawable(R.drawable.circle_lottery_shape_blue));
        circleTextView.setText(lotteryNums[i]);
        return circleTextView;
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private MyItemClickListener mListener;
        private TextView lottery_title, lottery_num, lottery_time;
        private LinearLayout lottery_layout;

        public MyViewHolder(View itemView, MyItemClickListener myItemClickListener) {
            super(itemView);
            //将全局的监听赋值给接口
            lottery_title = itemView.findViewById(R.id.lotter_item_title);
            lottery_num = itemView.findViewById(R.id.lotter_item_num);
            lottery_time = itemView.findViewById(R.id.lotter_item_time);
            lottery_layout = itemView.findViewById(R.id.lottery_layout);
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