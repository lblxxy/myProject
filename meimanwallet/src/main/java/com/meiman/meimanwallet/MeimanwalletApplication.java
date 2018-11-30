package com.meiman.meimanwallet;

import com.meiman.meimanwallet.exception.WalletException;
import com.meiman.meimanwallet.i18n.I18nUtils;
import com.meiman.meimanwallet.utils.PropertiesUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zeng_cc
 */
@SpringBootApplication
@MapperScan("com.meiman.meimanwallet.dao")
public class MeimanwalletApplication {

    public static void main(String[] args) {
        //初始化语言文件
        try {
            I18nUtils.setLanguage(PropertiesUtils.readProperty("language"));
        } catch (WalletException e) {
            System.out.println(e);
        }
        SpringApplication.run(MeimanwalletApplication.class, args);
    }
}
