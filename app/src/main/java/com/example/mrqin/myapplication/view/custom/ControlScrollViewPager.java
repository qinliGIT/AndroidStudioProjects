package com.example.mrqin.myapplication.view.custom;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Mrqin on 2018/3/14.
 * <p>
 * 不可滑动的viewpager
 */

public class ControlScrollViewPager extends ViewPager {

    private boolean isCanScroll = true;

    public ControlScrollViewPager(Context context) {
        super(context);
    }

    public ControlScrollViewPager(Context context, AttributeSet attrs) {

        super(context, attrs);

    }


    public void setScanScroll(boolean isCanScroll) {

        this.isCanScroll = isCanScroll;

    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        return false;
    }


    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return false;
    }
}