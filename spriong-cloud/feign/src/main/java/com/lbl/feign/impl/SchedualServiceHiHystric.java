package com.lbl.feign.impl;

import com.lbl.feign.service.FeignHiService;
import org.springframework.stereotype.Service;

@Service
public class SchedualServiceHiHystric implements FeignHiService {
    @Override
    public String sayHiFromClient(String name) {
        return "sorry "+name;
    }
}
