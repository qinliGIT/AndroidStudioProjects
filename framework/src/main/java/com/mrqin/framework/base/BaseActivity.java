package com.mrqin.framework.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;

import butterknife.ButterKnife;


/**
 * @data on 2018/3/9
 * @describe:
 */

public abstract class BaseActivity extends AppCompatActivity {
    public String TAG = this.getClass().getSimpleName();
    public Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 去掉标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        //去掉Activity上面的状态栏
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        mContext = getApplicationContext();

        setActivityView();

        ButterKnife.bind(this);

        initData();

    }

    /**
     * 绑定布局
     */
    public abstract void setActivityView();

    /**
     * 初始化数据
     */
    public abstract void initData();

    //自定义绑定控件
    public <T extends View> T $(int viewId) {
        return (T) findViewById(viewId);
    }

    @Override
    protected void onStop() {
        super.onStop();
        ButterKnife.unbind(this);
    }

}
