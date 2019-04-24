package com.lbl.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestConfigClientController {
    @Value("${foo}")
    String foo;
    @GetMapping("/hi")
    public String hi(){
        return foo;
    }
}
