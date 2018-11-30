package com.meiman.meimanwallet.controller;

import com.meiman.meimanwallet.entity.Alias;
import com.meiman.meimanwallet.service.AliasService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zeng_
 * @Date 2018/11/27
 */
@RestController
@RequestMapping("/alias")
public class AliasController {

    @Resource
    private AliasService aliasService;

    @RequestMapping("getAlias")
    public String getUser(String aliasId) {
        Alias alias = aliasService.getAliasById(aliasId);
        System.out.println(alias.getAddress());
        return "123456";
    }
}
