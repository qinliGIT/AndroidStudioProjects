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
import com.example.mrqin.myapplication.model.LuckBean;
import com.example.mrqin.myapplication.utils.TextViewUtils;
import com.example.mrqin.myapplication.view.custom.RatingBar;

import java.util.List;

/**
 * Created by Mrqin on 2018/3/14.
 */

public class LuckAdapter extends RecyclerView.Adapter<LuckAdapter.MyViewHolder> {
    private Context mContext;
    private LuckBean luckBean;

    public LuckAdapter(Context context, LuckBean luckBean) {
        this.mContext = context;
        this.luckBean = luckBean;
    }

    @Override

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(mContext, R.layout.luck_item_view_layout, null);
        //将全局的监听传递给holder
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.setIsRecyclable(false);
        //给空间赋值
        holder.day_notice.setText(luckBean.getShowapi_res_body().getDay().getDay_notice());
        holder.general_txt.setText(luckBean.getShowapi_res_body().getDay().getGeneral_txt());
        holder.money_txt.setText(luckBean.getShowapi_res_body().getDay().getMoney_txt());
        holder.love_txt.setText(luckBean.getShowapi_res_body().getDay().getLove_txt());
        holder.lucky_time_color.setText(luckBean.getShowapi_res_body().getDay().getLucky_time_color());
        holder.work_txt.setText(luckBean.getShowapi_res_body().getDay().getWork_txt());
        holder.lucky_num.setText(luckBean.getShowapi_res_body().getDay().getLucky_num());
        holder.love_star.setRating(luckBean.getShowapi_res_body().getDay().getLove_star());
        holder.money_star.setRating(luckBean.getShowapi_res_body().getDay().getMoney_star());
        holder.summary_star.setRating(luckBean.getShowapi_res_body().getDay().getSummary_star());
        holder.work_star.setRating(luckBean.getShowapi_res_body().getDay().getWork_star());
    }

    @Override
    public int getItemCount() {
        return 1;
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView day_notice, general_txt, love_txt,lucky_time_color,work_txt,lucky_num,money_txt;
        private RatingBar love_star,money_star,summary_star,work_star;

        public MyViewHolder(View itemView) {
            super(itemView);
            //将全局的监听赋值给接口
            day_notice = itemView.findViewById(R.id.day_notice);
            general_txt = itemView.findViewById(R.id.general_txt);
            love_txt = itemView.findViewById(R.id.love_txt);
            lucky_time_color = itemView.findViewById(R.id.lucky_time_color);
            money_txt = itemView.findViewById(R.id.money_txt);
            work_txt = itemView.findViewById(R.id.work_txt);
            love_star = itemView.findViewById(R.id.love_star);
            money_star = itemView.findViewById(R.id.money_star);
            summary_star = itemView.findViewById(R.id.summary_star);
            work_star = itemView.findViewById(R.id.work_star);
            lucky_num = itemView.findViewById(R.id.lucky_num);

        }
    }

 /**"day_notice": "异性缘佳，吃喝玩乐的机会多。",
            "general_txt": "有许多异性朋友主动邀约，特别是晚上，在闲聊中与异性朋友产生情愫。工作没有太大的压力，出现失误也易得到上司的谅解，若能积极一些会有更大的收获。今天不宜急于投资，适合观望。",
            "grxz": "双鱼座",
            "love_star": 4,
            "love_txt": "会有异性主动靠近，让你有些受宠若惊。单身者想恋爱，但仍停留在观望阶段。",
            "lucky_direction": "西北方",
            "lucky_num": "3",
            "lucky_time_color": "上午6:00-8:00浅莲红",
            "money_star": 2,
            "money_txt": "财务是今日的生活重心，虽然运气有点不稳定，外力干扰多了点，可是只要保守谨慎些，不会有太大的问题。",
            "summary_star": 3,
            "time": "20160113",
            "work_star": 3,
            "work_txt": "只要用心的对待工作，注意和拍档之间的交流与合作，手头的任务会很顺利的进行。"
  */
}