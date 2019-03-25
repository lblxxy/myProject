package com.lbl.ribbon.controller;

import com.lbl.ribbon.service.HiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HiController {

    @Resource
    HiService hiService;
    @GetMapping("/hi")
    public String hi(@RequestParam String name){
        return hiService.hiService(name);
    }

}
