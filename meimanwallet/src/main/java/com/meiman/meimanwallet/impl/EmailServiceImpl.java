package com.meiman.meimanwallet.impl;

import com.meiman.meimanwallet.service.EmailService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author zeng_
 * @Date 2018/12/3
 */
@Service("emailService")
public class EmailServiceImpl implements EmailService {

    @Async("taskExecutor")
    @Override
    public void sendEmil(String title,String context,String to){
        System.out.println("当前运行的线程名称：" + Thread.currentThread().getName());
    }
}
