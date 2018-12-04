package com.meiman.meimanwallet.controller;

import com.meiman.meimanwallet.service.EmailService;
import com.meiman.meimanwallet.service.MmUserService;
import com.meiman.meimanwallet.utils.RpcClientResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zeng_
 * @Date 2018/11/27
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    @Resource
    private EmailService emailService;
    @Resource
    private MmUserService mmUserService;

    @RequestMapping("getUser")
    public RpcClientResult getUser(Integer userId) {
        return mmUserService.selectByPrimaryKey(userId);
    }
}
