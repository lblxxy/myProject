package com.meiman.meimanwallet.utils;

import java.math.BigInteger;

/**
 * Long计算工具
 * @author zeng_cc
 */
public class LongUtils {

    private static BigInteger createBigDecimal(long value) {
        return BigInteger.valueOf(value);
    }

    /**
     * 加法
     * @param val1
     * @param val2
     * @return
     */
    public static long add(long val1, long val2) {
        BigInteger value1 = createBigDecimal(val1);
        BigInteger value2 = createBigDecimal(val2);
        return value1.add(value2).longValue();
    }

    /**
     * 减法
     * @param val1
     * @param val2
     * @return
     */
    public static long sub(long val1, long val2) {
        BigInteger value1 = createBigDecimal(val1);
        BigInteger value2 = createBigDecimal(val2);
        return value1.subtract(value2).longValue();
    }

    /**
     * 乘法
     * @param val1
     * @param val2
     * @return
     */
    public static long mul(long val1, long val2) {
        BigInteger value1 = createBigDecimal(val1);
        BigInteger value2 = createBigDecimal(val2);
        return value1.multiply(value2).longValue();
    }

    /**
     * 除法
     * @param val1
     * @param val2
     * @return
     */
    public static long div(long val1, long val2) {
        BigInteger value1 = createBigDecimal(val1);
        BigInteger value2 = createBigDecimal(val2);
        return value1.divide(value2).longValue();
    }

    /**
     * 求模
     * @param val1
     * @param val2
     * @return
     */
    public static long mod(long val1, long val2) {
        BigInteger value1 = createBigDecimal(val1);
        BigInteger value2 = createBigDecimal(val2);
        return value1.mod(value2).longValue();
    }
}
