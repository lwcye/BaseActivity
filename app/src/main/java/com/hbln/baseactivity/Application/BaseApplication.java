package com.hbln.baseactivity.Application;

import android.app.Application;

import org.xutils.x;

/**
 * Application类，用途：1.保存常驻数据 2.提供ApplicationContext
 * Created by lwc on 2015/12/26.
 */
public class BaseApplication extends Application{
    private static BaseApplication instance;
    //保存数据


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        //所有的工具的初始化
        init();
    }

    /**
     * 所有工具的初始化
     */
    private void init() {
        //xUtil的初始化
        x.Ext.init(this);
    }

    /**
     * BaseApplication
     *获得Application的实例,可以一次运行中保持不变化的数据
     * @return BaseApplication
     */
    public static BaseApplication getInstance() {
        return instance;
    }
}
