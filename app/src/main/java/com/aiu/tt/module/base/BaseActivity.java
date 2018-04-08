package com.aiu.tt.module.base;

import android.content.Context;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.r0adkll.slidr.model.SlidrInterface;

/**
 * Created by Administrator on 2018/4/4 0004.
 */

public class BaseActivity extends AppCompatActivity {
    private static final String TAG = "BaseActivity";
    protected SlidrInterface slidrInterface;
    protected Context mContext;
    private int iconType = 1;


    /**
     * 初始化 ToolBar
     * @param toolbar
     * @param homeAsUpEnabled
     * @param title
     */
    protected void initToolBar(Toolbar toolbar, boolean homeAsUpEnabled, String title){
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        //给左上角图标的左边加上一个返回的图标
        getSupportActionBar().setDisplayHomeAsUpEnabled(homeAsUpEnabled);
    }

}
