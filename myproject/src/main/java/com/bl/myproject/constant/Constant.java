package com.bl.myproject.constant;

/**
 * 系统常量配置配置
 * @author bl
 * @date 2019/5/28
 */
public interface Constant {
    /**
     * 系统当前版本
     */
    public static String SYSTEM_VERSION = "1.0";

    /**
     * 系统使用的编码方式
     */
    public static String DEFAULT_ENCODING = "UTF-8";

    /**
     * 访问方式，https
     */
    String HTTPS = "https://";

    /**
     * 访问方式，http
     */
    String HTTP = "http://";

    /**
     * url分隔符
     */
    String URI_SEPARATOR = "/";

    /**
     * 百分号
     */
    String URL_SPLIT_PERCENT = "%";

    /**
     * @
     */
    String URL_SPLIT_AT = "@";

    /**
     * 冒号
     */
    String COLON = ":";
    /**
     * OK
     */
    Object OK = "OK";
    /**
     * 当前系统bl标记
     */
    String WEB_NAME = "bl";
    /**
     * 登录类型
     */
    String USER_LOGIN = "login";
    /**
     * 未登录用户跳到登录界面
     */
    String TO_LOGIN = "/admin/toLogin";
}
