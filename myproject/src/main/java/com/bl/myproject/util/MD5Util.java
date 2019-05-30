package com.bl.myproject.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author bl
 * @date 2019/5/28
 */
public class MD5Util {
    /**
     * 十六进制下数字到字符的映射数组
     */
    private final static String[] HEX_DIGITS = { "0", "1", "2", "3", "4",
            "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

    public static String encodeByMD5(String originString){
        if(!StringUtil.isBlank(originString)){
            try {
                //创建具有指定算法名称的信息摘要
                MessageDigest md = MessageDigest.getInstance("MD5");
                //使用指定的字节数组对摘要进行最后更新，然后完成摘要计算
                byte[] results = md.digest(originString.getBytes());
                //将得到的字节数组变成字符串返回
                String resultString = byteArrayToHexString(results);
                return resultString.toUpperCase();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 转换字节数组为十六进制字符串
     * @param results 字节数组
     * @return    十六进制字符串
     */
    private static String byteArrayToHexString(byte[] results) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i=0;i<results.length;i++){
            stringBuffer.append(byteToHexString(results[i]));
        }
        return stringBuffer.toString();
    }

    /** 将一个字节转化成十六进制形式的字符串     */
    private static String byteToHexString(byte result) {
        int n = result;
        if (n < 0){
            n = 256+n;
        }
        int d1 = n/16;
        int d2 = n%16;
        return HEX_DIGITS[d1]+HEX_DIGITS[d2];
    }
}
