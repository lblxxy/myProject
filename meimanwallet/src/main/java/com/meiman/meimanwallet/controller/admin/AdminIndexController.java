package com.meiman.meimanwallet.controller.admin;

import com.meiman.meimanwallet.service.MmUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * @author zeng_
 */
@RestController
@RequestMapping("/admin")
public class AdminIndexController {
    @Resource
    private MmUserService mmUserService;

    @RequestMapping("/index")
    public String index(){
        return "aaa";
    }

    @RequestMapping("/login")
    public ModelAndView doLogin(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("title","登录");
        modelAndView.setViewName("login");
        return modelAndView;
    }


}
