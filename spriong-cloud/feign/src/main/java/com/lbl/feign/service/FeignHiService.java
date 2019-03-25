package com.lbl.feign.service;

import com.lbl.feign.impl.SchedualServiceHiHystric;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Service
@FeignClient(value = "eureka-client",fallback = SchedualServiceHiHystric.class)
public interface FeignHiService {
    @GetMapping("/hi")
    String sayHiFromClient(@RequestParam String name);
}
