package com.bl.myproject.util;

import org.apache.tomcat.util.file.ConfigFileLoader;

import java.util.Properties;

/**
 * 系统配置文件加载工具
 * @author bl
 * @date 2019/5/27
 */
public class PropertiesUtil {
    private static Properties properties = new Properties();
    //加载配置文件
    static {
        properties = ConfigLoader.loadProperties("bl.properties");
    }

    /**
     * 根据属性名获取配置文件的某个属性值
     * @param property 配置属性名
     * @return 配置具体属性值
     */
    public static String readProperty(String property){
        return properties.getProperty(property);
    }
}
