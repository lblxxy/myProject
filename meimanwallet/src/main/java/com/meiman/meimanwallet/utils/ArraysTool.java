package com.meiman.meimanwallet.utils;

import java.util.Arrays;

/**
 * @author zeng_cc
 */
public class ArraysTool {
    /**
     * 判断集合是不是空
     * @param bytes
     * @return
     */
    public static boolean isEmptyOrNull(byte[] bytes) {
        return (bytes == null || bytes.length == 0);
    }

    /**
     * 判断两个集合是否相等
     * @param array1
     * @param array2
     * @return
     */
    public static boolean arrayEquals(byte[] array1, byte[] array2) {
        return Arrays.equals(array1, array2);
    }
}
