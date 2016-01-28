package com.hbln.baseactivity.Tool;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间帮助类
 * Created by lwc on 2015/12/26.
 */
public class TimeUtil {

    private static TimeUtil ourInstance = new TimeUtil();

    public static TimeUtil getInstance() {
        return ourInstance;
    }

    private TimeUtil() {
    }

    /**
     * 获得当前时间
     *
     * @return 按yyyy MM dd HH mm ss SS  \n换行
     * @see [类、类#方法、类#成员]
     */
    public String getCurrentData(String DateFormat) {
        long l = System.currentTimeMillis();
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat(DateFormat);
        Date localDate = new Date(l);
        return localSimpleDateFormat.format(localDate);
    }


    /**
     * 获得当前时间
     *
     * @return 毫秒级
     */
    public Long getCurrentLongTime() {
        return System.currentTimeMillis();
    }

    /**
     * 获得当前星期
     *
     * @return 获得当前星期
     */
    public String getCurrentWeek() {
        switch (Calendar.getInstance().get(7)) {
            case 1:
                return "星期日";
            case 2:
                return "星期一";
            case 3:
                return "星期二";
            case 4:
                return "星期三";
            case 5:
                return "星期四";
            case 6:
                return "星期五";
            case 7:
                return "星期六";
            default:
                return "";
        }
    }

    /**
     * 获得时间对应的Date
     *
     * @param format    按yyyy MM dd HH mm ss SS   \n换行
     * @param paramLong 毫秒级
     * @return 对应的时间String
     */
    public String getTime(String format, long paramLong) {
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat(format);
        Date localDate = new Date(paramLong);
        return localSimpleDateFormat.format(localDate);
    }

    /**
     * 获得时间对应的Date
     *
     * @param format    按yyyy MM dd HH mm ss SS   \n换行
     * @param paramLong 时间毫秒级
     * @return 获得时间对应的Date
     */
    public String getTime(String format, String paramLong) {
        try {
            SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat(format);
            Date localDate = new Date(Long.valueOf(paramLong));
            return localSimpleDateFormat.format(localDate);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 通过Date对应的时间
     *
     * @param formatDate 按yyyy MM dd HH mm ss SS \n换行
     * @param date       Date值
     * @return 时间毫秒级
     * @throws ParseException 转换异常
     */
    public long getLongTime(String formatDate, String date) throws ParseException {
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat(formatDate);
        Date localDate = localSimpleDateFormat.parse(date);
        return localDate.getTime();
    }
}
