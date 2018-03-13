package com.example.mrqin.myapplication.adapter;

import java.util.List;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

/**
 * viewpager通用适配器
 */
public class ViewPagerViewAdapter extends PagerAdapter {
	private List<? extends View> viewList;

	public ViewPagerViewAdapter(List<? extends View> viewList) {
		this.viewList = viewList;
	}

	@Override
	public int getCount() {
		return viewList.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView(viewList.get(position));
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		View view = null;
		try {
			view = viewList.get(position);
			container.addView(view);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return view;
	}

	private int mChildCount = 0;
	@Override
	public void notifyDataSetChanged() {
		mChildCount = getCount();
		super.notifyDataSetChanged();
	}
	@Override
	public int getItemPosition(Object object) {
		if (mChildCount > 0) {
			mChildCount--;
			return POSITION_NONE;
		}
		return super.getItemPosition(object);
	}
}
