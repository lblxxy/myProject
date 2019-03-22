package com.lbl.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    //远程配置文件里的参数
    @Value("${foo}")
    String key;

    @RequestMapping(value = "/hi")
    public String cfgTest(){
        return "Config Param Is：" + key;
    }

    @PostMapping(value = "/actuator/bus-refresh")
    public void refresh(){
        System.out.println("刷新了？？？？");
    }
}
