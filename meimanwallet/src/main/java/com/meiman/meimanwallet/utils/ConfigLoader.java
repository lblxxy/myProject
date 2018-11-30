package com.meiman.meimanwallet.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 加载配置文件
 * @author zeng_cc
 */
public class ConfigLoader {

    /**
     * 根据资源名称加载资源
     * @param fileName 资源文件名称
     * @return prop对象
     * @throws IOException
     */
    public static Properties loadProperties(String fileName) throws IOException {
        InputStream is = ConfigLoader.class.getClassLoader().getResourceAsStream(fileName);
        Properties prop = new Properties();
        prop.load(is);
        is.close();
        return prop;
    }
}
