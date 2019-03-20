package com.lbl.servicefeign.controller;

import com.lbl.servicefeign.test.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {

    @Autowired
    Test testFegin;

    @GetMapping(value = "/hi")
    public String sayHi(@RequestParam String name){
        return testFegin.sayHiFormCLientOne(name);
    }

}
