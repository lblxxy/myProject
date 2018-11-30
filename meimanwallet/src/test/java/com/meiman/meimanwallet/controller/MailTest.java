package com.meiman.meimanwallet.controller;

import com.meiman.meimanwallet.utils.MailUtil;
import org.junit.Test;

/**
 * @author zeng_
 * @Date 2018/11/28
 */
public class MailTest {

    @Test
    public void mailTest(){
        MailUtil.sendEmail("你好，我是小曾","邀请你加入我们","906606200@qq.com");
    }

}
