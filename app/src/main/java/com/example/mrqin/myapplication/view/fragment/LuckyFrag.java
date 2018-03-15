package com.example.mrqin.myapplication.view.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.mrqin.myapplication.R;
import com.example.mrqin.myapplication.adapter.LuckGridAdapter;
import com.example.mrqin.myapplication.model.LotteryAdapterBean;
import com.example.mrqin.myapplication.view.lottery.LotteryMoreAc;
import com.example.mrqin.myapplication.view.lottery.LuckMoreAc;

/**
 * Created by Mrqin on 2018/3/9.
 */

public class LuckyFrag extends Fragment {

    private View view;
    private GridView luck_list;
    private LuckGridAdapter adapter;

    private Resources res;
    private int[] item_constellation_img;
    private String[] item_more_constellation_txt;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_layout_lucky, null);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //测试提交新版本
        init();
        initUI();
    }

    private void initUI() {
        luck_list = view.findViewById(R.id.luck_list);
        adapter = new LuckGridAdapter(getContext(), item_constellation_img, item_more_constellation_txt);
        luck_list.setAdapter(adapter);

        luck_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                LotteryAdapterBean bean = mDataAd.get(position);
                Intent in = new Intent(getActivity(), LuckMoreAc.class);
//                in.putExtra("name", bean.getName());
                switch (i){

                }
                startActivity(in);
            }
        });
    }

    private void init() {
        res = getResources();
        item_constellation_img = new int[]{R.mipmap.love_ic_aries,
                R.mipmap.love_ic_taurus, R.mipmap.love_ic_gemin,
                R.mipmap.love_ic_cancer, R.mipmap.love_ic_leo,
                R.mipmap.love_ic_virgo, R.mipmap.love_ic_libra,
                R.mipmap.love_ic_scorpio, R.mipmap.love_ic_sagittarius,
                R.mipmap.love_ic_capricornus, R.mipmap.love_ic_aquarius,
                R.mipmap.love_ic_pisces};
        item_more_constellation_txt = res
                .getStringArray(R.array.ac_marry_constellation);
    }
}
