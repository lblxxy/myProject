package com.bl.myproject.util;

import com.bl.myproject.constant.ErrorCode;
import com.bl.myproject.exception.BlException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 加载配置文件，根据文件名
 * @author bl
 * @date 2019/5/27
 */
public class ConfigLoader {

    private static final Logger logger = LoggerFactory.getLogger(ConfigLoader.class);

    /**
     * 根据资源名称加载资源
     * @param fileName 资源文件名称
     * @return prop对象
     * @throws IOException
     */
    public static Properties loadProperties(String fileName){
        InputStream in = ConfigLoader.class.getClassLoader().getResourceAsStream(fileName);
        Properties properties = new Properties();
        try {
            properties.load(in);
            in.close();
        } catch (IOException e) {
            logger.error("读取配置文件出错");
           throw new  BlException(ErrorCode.LOAD_CONFIG_ERROR);
        }
        return properties;
    }
}
