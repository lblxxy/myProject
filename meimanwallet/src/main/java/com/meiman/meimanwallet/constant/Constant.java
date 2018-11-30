package com.meiman.meimanwallet.constant;

/**
 * 系统常量配置信息
 * @author zeng_cc
 */
public interface Constant {
    /**
     * 系统当前版本
     */
    public static String WALLET_VERSION = "1.0";
    /**
     * 系统使用的编码方式
     */
    public static String DEFAULT_ENCODING = "UTF-8";
    /**
     * 系统语言配置
     */
    String CFG_SYSTEM_LANGUAGE = "language";
    /**
     * 默认语言配置
     */
    String DEFAULT_LANGUAGE = "zh-cn";
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
     * 冒号
     */
    String COLON = ":";
    /**
     * ip访问限制
     */
    String REQUEST_FREQUENCY = "request.frequency";
    /**
     * ip范文限制次数
     */
    String DEFAULT_REQUEST_FREQUENCY = "100";
    /**
     * 分隔符
     */
    String WHITE_SHEET_SPLIT = ",";
    /**
     * 获取真实ip的时候，如果是unKnown，需要重新获取
     */
    String IP_UNKNOWN = "unKnown";
}
