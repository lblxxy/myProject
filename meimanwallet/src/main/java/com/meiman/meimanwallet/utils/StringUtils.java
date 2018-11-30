package com.meiman.meimanwallet.utils;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * @author zeng_cc
 */
public class StringUtils {

    public static boolean isBlank(String str) {
        return null == str || str.trim().length() == 0;
    }

    public static boolean isNull(String str) {
        return null == str || str.trim().length() == 0 || "null".equalsIgnoreCase(str.trim());
    }

    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    public static boolean isNotNull(String str) {
        return !isNull(str);
    }

    public static String getUuidAndReplace() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static byte[] bytes(String value) {
        return (value == null) ? null : value.getBytes(UTF_8);
    }

    /**
     * 验证是否是数字
     */
    private static final Pattern NUMBER_PATTERN = Pattern.compile("[1-9]\\d*|0");

    /**
     * 验证是否包含特殊字符 true为包含，false为不包含
     * @param str 要验证的字符串
     * @return
     */
    public static boolean isSpecialChar(String str) {
        String regEx = "[ _`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\r|\t";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.find();
    }

}
