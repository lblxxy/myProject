package com.meiman.meimanwallet.utils;

/**
 * 时间服务相关
 * @author zeng_cc
 */
public class TimeService{

    /**
     * 获取当前时间
     * @return 当前时间的毫秒数据
     */
    public static long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    /**
     * 每天的毫秒数
     */
    public static long  MILLISECONDS_TIME_DAY=86400000;

    /**
     * 每小时的毫秒数
     */
    public static long  SECONDS_TIME_HOUR_SECOND=3600;
}
