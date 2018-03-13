package com.example.mrqin.myapplication.view.logo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

import com.example.mrqin.myapplication.MainActivity;
import com.example.mrqin.myapplication.R;
import com.example.mrqin.myapplication.adapter.ViewPagerViewAdapter;
import com.example.mrqin.myapplication.view.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 引导图
 */
public class AcLeadPage extends BaseActivity {

    private int[] images = {R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background, R.drawable.ic_launcher_background};

    private ViewPager vp_pager;
    private int currentPage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.ac_lead_page);

        vp_pager = findViewById(R.id.vp_pager);
        vp_pager.setAdapter(new ViewPagerViewAdapter(getViewList()));

        vp_pager.addOnPageChangeListener(new OnPageChangeListener() {
            @Override
            public void onPageScrollStateChanged(int arg0) {
            }

            @Override
            public void onPageSelected(int arg0) {
                currentPage = arg0;
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }
        });

        vp_pager.setOnTouchListener(listener);
    }

    public View.OnTouchListener listener = new View.OnTouchListener() {
        float startX;
        float startY;//没有用到
        float endX;
        float endY;//没有用到

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    startX = motionEvent.getX();
                    startY = motionEvent.getY();
                    break;
                case MotionEvent.ACTION_UP:
                    endX = motionEvent.getX();
                    endY = motionEvent.getY();
                    WindowManager windowManager = (WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
                    //获取屏幕的宽度
                    Point size = new Point();
                    windowManager.getDefaultDisplay().getSize(size);
                    int width = size.x;
                    //首先要确定的是，是否到了最后一页，然后判断是否向左滑动，并且滑动距离是否符合，我这里的判断距离是屏幕宽度的4分之一（这里可以适当控制）
                    if (currentPage == (images.length - 1) && startX - endX >= (width / 4)) {
                        go();
                    }
                    break;
            }
            return false;
        }
    };


    private void go() {
        isShow(this, false);
        Intent intent = new Intent(AcLeadPage.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private List<View> getViewList() {
        List<View> views = new ArrayList<View>();
        for (int i = 0; i < images.length; i++) {
            View v = getView(images[i]);
            views.add(v);
            if (i == images.length - 1) {
                v.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        go();
                    }
                });
            }
        }
        return views;
    }

    private View getView(int image) {
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(image);
        imageView.setScaleType(ScaleType.FIT_XY);
        return imageView;
    }

    public static boolean isShow(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                "leadPage", Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean("isShowLead_", true);
    }

    public static void isShow(Context context, boolean isShow) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                "leadPage", Context.MODE_PRIVATE);
        Editor editor = sharedPreferences.edit();
        editor.putBoolean("isShowLead_", isShow);
        editor.commit();
    }
}
