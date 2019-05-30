package com.bl.myproject.util;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Long计算工具
 * @author bl
 * @date 2019/5/30
 */
public class LongUtil {
    private static BigInteger createBigDecimal(long value){
        return BigInteger.valueOf(value);
    }

    /**
     * 加法
     * @param value1 a
     * @param value2 b
     * @return 和
     */
    public static long add(long value1,long value2){
        BigInteger a = createBigDecimal(value1);
        BigInteger b = createBigDecimal(value2);
        return a.add(b).longValue();
    }
    /**
     * 剪法
     * @param value1 a
     * @param value2 b
     * @return 差
     */
    public static long sub(long value1,long value2){
        BigInteger a = createBigDecimal(value1);
        BigInteger b = createBigDecimal(value2);
        return a.subtract(b).longValue();
    }
    /**
     * 乘法
     * @param value1 a
     * @param value2 b
     * @return 积
     */
    public static long mul(long value1,long value2){
        BigInteger a = createBigDecimal(value1);
        BigInteger b = createBigDecimal(value2);
        return a.multiply(b).longValue();
    }
    /**
     * 除法
     * @param value1 a
     * @param value2 b
     * @return 商
     */
    public static long div(long value1,long value2){
        BigInteger a = createBigDecimal(value1);
        BigInteger b = createBigDecimal(value2);
        return a.divide(b).longValue();
    }
    /**
     * 模
     * @param value1 a
     * @param value2 b
     * @return 求模
     */
    public static long mod(long value1,long value2){
        BigInteger a = createBigDecimal(value1);
        BigInteger b = createBigDecimal(value2);
        return a.mod(b).longValue();
    }


}
