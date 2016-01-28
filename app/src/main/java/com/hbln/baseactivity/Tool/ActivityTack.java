package com.hbln.baseactivity.Tool;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Activity的任务栈
 * Created by lwc on 2015/12/26.
 */
public class ActivityTack {
    public static ActivityTack tack;
    public List<Activity> activityList;

    private ActivityTack() {
        activityList = new ArrayList<>();
    }

    /**
     * 单列模式
     *
     * @return 实体
     */
    public static ActivityTack getInstances() {
        if (tack == null) {
            tack = new ActivityTack();
        }
        return tack;
    }

    /**
     * 在栈内增加Activity
     *
     * @param paramActivity 目标activity
     */
    public void addActivity(Activity paramActivity) {
        activityList.add(paramActivity);
    }

    /**
     * 全部退出
     */
    public void exit() {
        while (activityList.size() > 0)
            (activityList.get(-1 + activityList.size())).finish();
        System.exit(0);
    }

    /**
     * 通过class获得Activity
     *
     * @param paramClass 目标class
     * @return activity
     */
    public Activity getActivityByClass(Class paramClass) {
        for (Activity localActivity : activityList) {
            if (localActivity.getClass().equals(paramClass)) {
                return localActivity;
            }
        }
        return null;
    }

    /**
     * 通过className获得Activity
     *
     * @param paramString className
     * @return activity
     */
    public Activity getActivityByClassName(String paramString) {
        for (Activity localActivity : this.activityList) {
            if (localActivity.getClass().getName().contains(paramString))
                return localActivity;
        }
        return null;
    }

    /**
     * 移除Activity
     *
     * @param paramActivity 目标Activity
     */
    public void removeActivity(Activity paramActivity) {
        activityList.remove(paramActivity);
    }
}
