package com.meiman.meimanwallet.i18n;

import com.meiman.meimanwallet.constant.Constant;
import com.meiman.meimanwallet.constant.ErrorCodeMsg;
import com.meiman.meimanwallet.exception.WalletException;
import com.meiman.meimanwallet.utils.ConfigLoader;
import com.meiman.meimanwallet.utils.StringUtils;

import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 语言配置
 * @author zeng_cc
 *
 */
public class I18nUtils {

    /**
     * 语言数据
     */
    private static final Map<String, Properties> ALL_MAPPING = new HashMap<>();

    /**
     * 系统当前已选择语言包
     */
    private static Properties nowMapping = new Properties();

    /**
     * 默认语言设置为英文
     */
    private static String key = "en";

    /**
     * 默认语言包存放文件夹名称
     */
    private static final String FOLDER = "languages";

    /**
     * 初始化，加载所有语言包
     */
    static {
        try {
            URL furl = I18nUtils.class.getClassLoader().getResource(FOLDER);
            Properties languages = null;
            if (null != furl) {
                File folderFile = new File(furl.getPath());
                for (File file : folderFile.listFiles()) {
                    String key = file.getName();
                    languages = ConfigLoader.loadProperties(FOLDER+Constant.URI_SEPARATOR+key);
                    ALL_MAPPING.put("key", languages);
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }


    public static void setLanguage(String lang) throws WalletException {
        if (StringUtils.isBlank(lang)) {
            throw new WalletException(ErrorCodeMsg.LANGUAGE_CANNOT_SET_NULL);
        }
        key = lang;
        nowMapping = ALL_MAPPING.get(lang);
    }

    /**
     * 根据系统当前语言，获取语言包
     * @param id
     * @return
     */
    public static String get(String id) {
        if (nowMapping == null) {
            nowMapping = ALL_MAPPING.get(key);
        }
        return nowMapping.getProperty(id + "");
    }
}
