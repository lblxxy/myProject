package com.bl.myproject.controller;

import com.bl.myproject.constant.EntityConstant;
import com.bl.myproject.entity.BlUserExample;
import com.bl.myproject.service.BlUserService;
import com.bl.myproject.util.IntergerUtil;
import com.bl.myproject.util.ResponseResult;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author bl
 * @date 2019-5-24
 */
@RestController
@RequestMapping("/admin")
public class UserController {

    @Resource
    private BlUserService service;

    @RequestMapping(value = "/list",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseResult getUserList(Integer page,Integer limit){

        BlUserExample example = new BlUserExample();
        if(!IntergerUtil.isNaturalNumber(page)){
            page=1;
        }
        if(!IntergerUtil.isNaturalNumber(limit)){
            limit=10;
        }
        //添加分页
        if(IntergerUtil.isNaturalNumber(page) && IntergerUtil.isNaturalNumber(limit)){
            example.setPageSize(limit);
            example.setStartRow((page-1)*limit);
        }
        example.createCriteria().andDelEqualTo(EntityConstant.ONE);
        return service.selectByExample(example);
    }
}
