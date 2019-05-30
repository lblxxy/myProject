package com.bl.myproject.util;

import com.bl.myproject.constant.Constant;
import com.bl.myproject.constant.EntityConstant;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串工具类
 * @author bl
 * @date 2019-5-28
 */
public class StringUtil {


    /**
     * emoji表情过滤正则表达式
     */
    private static Pattern pattern = Pattern.compile("[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]");
    private static Pattern chinsesPattern = Pattern.compile("[\u4e00-\u9fa5]");


    public static boolean isBlank(String str) {
        return null == str || str.trim().length() == 0;
    }

    /**
     * 验证是否是邮箱
     * @param email 邮箱地址
     * @return 验证结果true表示是
     */
    public static boolean isEmail(String email) {
        if (isBlank(email)) {
            return false;
        }
        String regEx1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern p;
        Matcher m;
        p = Pattern.compile(regEx1);
        m = p.matcher(email);
        return m.matches();
    }

    /**
     * 是否包含中文
     * @param str  字符串
     * @return true表示包含,false表示错误或者不包含
     */
    public static boolean hasChinese(String str){
        return chinsesPattern.matcher(str).find();
    }

    /**
     * 验证是否包含特殊字符 true为包含，false为不包含
     *
     * @param str 要验证的字符串
     * @return
     */
    public static boolean isSpecialChar(String str) {
        String regEx = "[ _`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\r|\t";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.find();
    }

    /**
     * 获取like字符串
     * @param str 原字符串
     * @return 增加了%的字符串或者空
     */
    public static String getLikeStr(String str){
        return Constant.URL_SPLIT_PERCENT+str+Constant.URL_SPLIT_PERCENT;
    }

    /**
     * 随机获取字符串
     * @param length 随机字符串长度
     * @return 随机字符串
     */
    public static String getRandomString(int length) {
        if (length <= 0) {
            return "";
        }
        char[] randomChar = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a', 's', 'd',
                'f', 'g', 'h', 'j', 'k', 'l', 'z', 'x', 'c', 'v', 'b', 'n', 'm'};
        Random random = new Random();
        StringBuilder stringBuffer = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stringBuffer.append(randomChar[Math.abs(random.nextInt()) % randomChar.length]);
        }
        return stringBuffer.toString();
    }

    /**
     * 验证密码长度是否符合规范
     * @param pwd 密码
     * @return true符合，false不符合
     */
    public static boolean checkPwdLength(String pwd) {
        if(isBlank(pwd)){
            return false;
        }
        if(pwd.trim().length()>= EntityConstant.MIN_PWD_LENGTH && pwd.trim().length()< EntityConstant.MAX_PWD_LENGTH){
            return true;
        }
        return false;
    }
}
