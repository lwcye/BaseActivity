package com.hbln.baseactivity.Application;

import android.app.Application;

import org.xutils.x;

/**
 * 这个类的作用
 * Created by lwc on 2015/12/26.
 */
public class MyApplication extends Application{
    private static MyApplication instance;
    //保存数据


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        //所有的工具的初始化
        init();
    }

    private void init() {
        //xUtil的初始化
        x.Ext.init(this);
    }

    /**
     * MyApplication
     *获得Application的实例,可以一次运行中保持不变化的数据
     * @return MyApplication
     */
    public static MyApplication getInstance() {
        return instance;
    }
}
