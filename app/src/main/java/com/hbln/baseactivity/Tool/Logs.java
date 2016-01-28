package com.hbln.baseactivity.Tool;

import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.hbln.baseactivity.Application.BaseApplication;

/**
 * Log帮助类
 * Created by lwc on 2015/12/26.
 */
public class Logs {
    static BaseApplication mApplication = BaseApplication.getInstance();
    private static boolean isDebug = true;
    private static String TAG = "lwc";

    /**
     * log.v输出
     * @param string 输出字符
     */
    public static void v(Object string) {
        if (isDebug)
            Log.v(TAG, "" + string);
    }

    /**
     * log.i输出
     * @param string 输出字符
     */
    public static void i(Object string) {
        if (isDebug)
            Log.i(TAG, "" + string);
    }
    /**
     * log.e输出
     * @param string 输出字符
     */
    public static void e(Object string) {
        if (isDebug)
            Log.e(TAG, "" + string);
    }
    /**
     * log.e输出,待class名的
     * @param string 输出字符
     */
    public static void e(Class aClass, Object string) {
        Logs.e(aClass.getName() + ":" + string);
    }

    /**
     * 不定参数的log
     *
     * @param className 当前class
     * @param args      输出参数 按args[0]=args[1],
     */
    public static void e(Class className, Object... args) {
        if (isDebug) {
            StringBuilder sb = new StringBuilder();
            int size = args.length;
            for (int i = 0; i < size; i++) {
                if (i % 2 == 0) {
                    sb.append(args[i]).append("=");
                } else {
                    sb.append(args[i]).append(",");
                }
            }
            Logs.e(className, sb);
        }
    }


    /**
     * Toast弹出。时间为长
     * @param string 输出字符
     */
    public static void tl(Object string) {
        Toast.makeText(mApplication, "" + string, Toast.LENGTH_LONG).show();
    }
    /**
     * Toast弹出。时间为短
     * @param string 输出字符
     */
    public static void ts(Object string) {
        Toast.makeText(mApplication, "" + string, Toast.LENGTH_SHORT).show();
    }

    /**
     * Toast弹出。时间为长，位于屏幕中央
     * @param string 输出字符
     */
    public static void t_center_long(Object string) {
        Toast toast = Toast.makeText(mApplication, "" + string, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 10);
        toast.show();
    }

    /**
     * Toast弹出。时间为短，位于屏幕中央
     * @param string 输出字符
     */
    public static void t_center_short(Object string) {
        Toast toast = Toast.makeText(mApplication, "" + string, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 10);
        toast.show();
    }

    /**
     * snackbar长久存在且有按钮
     * @param view 视图
     * @param content 文本
     * @param btn 按钮文本
     * @param listener 按钮监听
     */
    public static void snackbar_indefintite(View view, String content, String btn, View.OnClickListener listener) {
        Snackbar.make(view, content, Snackbar.LENGTH_INDEFINITE).setAction(btn, listener).show();
    }

    /**
     *snackbar长久存在且有按钮，点击直接消失
     * @param view 视图
     * @param content 文本
     * @param btn 按钮文本
     */
    public static void snackbar_indefintite(View view, String content, String btn) {
        snackbar_indefintite(view, content, btn, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

    /**
     *snackbar 短暂出现
     * @param view 视图
     * @param content 文本
     */
    public static void snackbar_short(View view, String content) {
        Snackbar.make(view, content, Snackbar.LENGTH_SHORT).show();
    }

    /**
     *snackbar 网络请求错误时出现的文本
     * @param view 视图
     * @param code 错误代码
     * @param listener 监听按钮
     */
    public static void snackbar_netFail(View view, int code, View.OnClickListener listener) {
        snackbar_indefintite(view, "网络链接错误：" + code, "重新链接", listener);
    }
}
