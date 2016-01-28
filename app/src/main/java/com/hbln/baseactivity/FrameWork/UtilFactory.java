package com.hbln.baseactivity.FrameWork;

import com.hbln.baseactivity.Tool.ImageLoadUtil;
import com.hbln.baseactivity.Tool.SharedPreferencesUtil;
import com.hbln.baseactivity.Tool.TimeUtil;
import com.hbln.baseactivity.Tool.UiUtil;

/**
 * 自定义的工具工厂类
 * Created by lwc on 2015/12/24.
 */
public class UtilFactory {

    /**
     * 图片下载类
     *
     * @return ImageLoadUtil
     */
    public static ImageLoadUtil getImageLoadUtil() {
        return ImageLoadUtil.getInstance();
    }

    /**
     * 共同资源类
     *
     * @return SharedPreferencesUtil
     */
    public static SharedPreferencesUtil getSharedPreferencesUtil() {
        return SharedPreferencesUtil.getInstance();
    }

    /**
     * 时间转换帮助类
     *
     * @return TimeUtil
     */
    public static TimeUtil getTimeUtil() {
        return TimeUtil.getInstance();
    }

    /**
     * 界面转换帮助类类
     *
     * @return UiUtil
     */
    public static UiUtil getUiUtil() {
        return UiUtil.getInstance();
    }
}

