package com.example.mrqin.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.mrqin.myapplication.adapter.TabFragmentPagerAdapter;
import com.example.mrqin.myapplication.view.fragment.LotteryFrag;
import com.example.mrqin.myapplication.view.fragment.LuckyFrag;
import com.example.mrqin.myapplication.view.fragment.RobotFrag;

import java.util.ArrayList;
import java.util.List;

/**
 * TAB主页
 */
public class MainActivity extends AppCompatActivity {

    private ViewPager myViewPager;
    private List<Fragment> list;
    private TabFragmentPagerAdapter adapter;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    myViewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_dashboard:
                    myViewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_notifications:
                    myViewPager.setCurrentItem(2);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UI();
        setData();

    }

    private void UI() {
        myViewPager = (ViewPager) findViewById(R.id.myViewPager);
    }

    private void setData() {
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        myViewPager.addOnPageChangeListener(new MyPagerChangeListener());

        //把Fragment添加到List集合里面
        list = new ArrayList<>();
        list.add(new LotteryFrag());
        list.add(new LuckyFrag());
        list.add(new RobotFrag());
        adapter = new TabFragmentPagerAdapter(getSupportFragmentManager(), list);
        myViewPager.setAdapter(adapter);
        myViewPager.setCurrentItem(0);  //初始化显示第一个页面
        myViewPager.setOffscreenPageLimit(3);
    }


    /**
     * 设置一个ViewPager的侦听事件，当左右滑动ViewPager时菜单栏被选中状态跟着改变
     */
    public class MyPagerChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrollStateChanged(int arg0) {
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        @Override
        public void onPageSelected(int arg0) {
            switch (arg0) {
                case 0:

                    break;
                case 1:

                    break;
                case 2:

                    break;
            }
        }
    }

}
