package com.hbln.baseactivity.Tool;

import android.app.Activity;
import android.content.Intent;

import com.hbln.baseactivity.MainActivity;

/**
 * Activity切换动画类
 * Created by lwc on 2015/12/26.
 */
public class UiUtil {

    private static UiUtil ourInstance = new UiUtil();

    public static UiUtil getInstance() {
        return ourInstance;
    }

    private UiUtil() {
    }

    /**
     * 进入：移入  退出：缩小
     *
     * @param Activity   Activity
     * @param paramClass paramClass
     */
    public void startUi(Activity Activity, Class<?> paramClass) {
        Intent Intent = new Intent(Activity, paramClass);
        Activity.startActivity(Intent);
        ActivityTack.getInstances().addActivity(Activity);
    }

    /**
     * 进入：放大  退出：移除
     *
     * @param Activity   Activity
     * @param paramClass 目标界面
     */
    public void startUi_finish(Activity Activity, Class<?> paramClass) {
        Intent Intent = new Intent(Activity, paramClass);
        Activity.startActivity(Intent);
        Activity.finish();
    }

    /**
     * 进入：移入  退出：缩小
     *
     * @param Activity   Activity
     * @param paramClass 目标界面
     * @param intent 链接
     */
    public void startUi(Activity Activity, Class<?> paramClass, Intent intent) {
        intent.setClass(Activity, paramClass);
        Activity.startActivity(intent);
        ActivityTack.getInstances().addActivity(Activity);
    }

    /**
     * 进入：移入  退出：缩小
     *
     * @param Activity   Activity
     * @param paramClass 目标界面
     * @param intent 链接
     */
    public void startUi_finish(Activity Activity, Class<?> paramClass, Intent intent) {
        intent.setClass(Activity, paramClass);
        Activity.startActivity(intent);
        Activity.finish();
    }

    /**
     * 进入：放大 退出：移除
     *
     * @param Activity Activity
     */
    public void startMianUi(Activity Activity) {
        Intent intent = new Intent();
        intent.setClass(Activity, MainActivity.class);
        Activity.startActivity(intent);
        ActivityTack.getInstances().addActivity(Activity);
    }

    /**
     * 进入：放大 退出：移除
     *
     * @param Activity Activity
     */
    public void startMianUi_finish(Activity Activity) {
        Intent intent = new Intent();
        intent.setClass(Activity, MainActivity.class);
        Activity.startActivity(intent);
        Activity.finish();
    }

    /**
     * SystemUtil
     * 进入：放大  退出：移除
     *
     * @param Activity Activity
     */
    public void finish(Activity Activity) {
        Activity.finish();
    }

    public void nofinish(Activity Activity) {

    }
}

