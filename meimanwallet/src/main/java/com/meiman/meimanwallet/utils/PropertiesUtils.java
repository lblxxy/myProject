package com.meiman.meimanwallet.utils;

import java.io.IOException;
import java.util.Properties;

/**
 * 系统配置文件加载工具类
 * @author zeng_cc
 */
public class PropertiesUtils {
    private static Properties properties=new Properties();

    static{
        try {
            properties = ConfigLoader.loadProperties("meiman.properties");
        } catch (IOException e) {
            System.out.println("加载系统配置文件错误");
        }
    }

    /**
     * 读取配置文件，如果没有读取到，就返回默认值
     * @param property
     * @param defaultValue
     * @return
     */
    public static String readProperty(String property, String defaultValue){
        return properties.getProperty(property, defaultValue);
    }

    /**
     * 读取配置文件
     * @param property
     * @return
     */
    public static String readProperty(String property){
        return properties.getProperty(property);
    }
}
