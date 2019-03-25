package com.lbl.feign.controller;

import com.lbl.feign.service.FeignHiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HIController {
    @Resource
    FeignHiService hiService;
    @GetMapping("/hi")
    public String sayHi(@RequestParam String name){
        return hiService.sayHiFromClient(name);
    }
}
