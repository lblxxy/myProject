package com.meiman.meimanwallet.utils;

/**
 * @author zeng_
 * @Date 2018/12/5
 */
public class IntegerUtil {
    /**
     * 验证数字是否是一个正常的自然数
     * @param num  数字
     * @return true表示不是一个正常的自然数
     */
    public static boolean isNaturalNumber(Integer num) {
        return null == num || num <= 0;
    }
}
