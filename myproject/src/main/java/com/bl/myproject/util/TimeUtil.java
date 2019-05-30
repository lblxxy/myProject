package com.bl.myproject.util;

import java.util.Calendar;

/**
 * 时间工具类
 * @author bl
 * @date 2019/5/30
 */
public class TimeUtil {

    /**
     * 获取当前时间戳
     * @return 当前时间戳毫秒数
     */
    public static long currentTimeMillis(){
        return System.currentTimeMillis();
    }

    /**
     * 当前时间戳字符串
     * @return 当前时间戳字符串
     */
    public static  String currentTimeMillisStr(){
        return System.currentTimeMillis()+"";
    }

    /**
     * 获取当前月份
     * @return 当前月份
     */
    public static Integer currentMonth(){
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.MONTH)+1;
    }

    /**
     * 一天的毫秒数
     */
    public static final long DAY_OF_MILLISECONDS = 86400000;
}
