package com.lbl.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope //需要在配置的页面加上，就是说附带@Value的页面加上此注解
public class TestConfigClientController {
    @Value("${foo}")
    String foo;
    @GetMapping("/hi")
    public String hi(){
        return foo;
    }
    @PostMapping("/actuator/bus-refresh")
    public void busRefresh(){
        System.out.println("foo:"+foo);
    }

}
