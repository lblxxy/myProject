package com.bl.myproject.constant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

/**
 * 项目初始化，需要执行的操作
 * @author bl
 * @date 2019/5/27
 */
public class InitConstant implements ApplicationRunner {
    private static final Logger log = LoggerFactory.getLogger(ApplicationRunner.class);

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //todo 初始化操作
    }
}
