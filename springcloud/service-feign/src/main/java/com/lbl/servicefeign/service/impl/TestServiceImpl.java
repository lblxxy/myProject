package com.lbl.servicefeign.service.impl;

import com.lbl.servicefeign.test.Test;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements Test {

    @Override
    public String sayHiFormCLientOne(String name) {
        return "sorry "+name;
    }
}
