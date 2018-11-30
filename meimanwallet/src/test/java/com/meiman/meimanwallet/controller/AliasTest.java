package com.meiman.meimanwallet.controller;

import com.meiman.meimanwallet.entity.Alias;
import com.meiman.meimanwallet.service.AliasService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author zeng_
 * @Date 2018/11/27
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AliasTest {

    @Resource
    private AliasService aliasService;

    @Test
    public void alisDaoSelectTest(){
        Alias alias = aliasService.getAliasById("123");
        System.out.println(alias);
    }

    @Test
    public void threadTeset(){
        aliasService.sendEmil("","","");

    }
}
