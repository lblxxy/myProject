package com.meiman.meimanwallet.controller.admin;

import com.meiman.meimanwallet.service.MmUserService;
import com.meiman.meimanwallet.utils.RpcClientResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * @author zeng_
 * @Date 2018/12/5
 */
@RestController
@RequestMapping("/admin")
public class AdminUserListController {

    @Resource
    private MmUserService mmUserService;

    /**
     * 跳转用户界面
     * @return
     */
    @RequestMapping("/member")
    public ModelAndView memberList(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("title","用户列表");
        modelAndView.setViewName("member-list");
        return modelAndView;
    }

    /**
     * 获取用户列表
     * @param page
     * @param limit
     * @param stu
     * @param rank
     * @param role
     * @param name
     * @return
     */
    @RequestMapping("/api/memberList")
    public RpcClientResult getList(Integer page,Integer limit,Integer stu,Integer rank,Integer role,String name) {
        return mmUserService.selectList(page,limit,stu,rank,role,name);
    }
}
