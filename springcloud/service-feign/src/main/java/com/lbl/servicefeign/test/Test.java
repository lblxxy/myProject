package com.lbl.servicefeign.test;

import com.lbl.servicefeign.service.impl.TestServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "SERVICE-HI",fallback = TestServiceImpl.class)
public interface Test {
    @GetMapping(value = "/hi")
    String sayHiFormCLientOne(@RequestParam(value = "name") String name);
}
