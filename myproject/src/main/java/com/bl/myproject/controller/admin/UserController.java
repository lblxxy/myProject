package com.bl.myproject.controller.admin;

import com.bl.myproject.constant.EntityConstant;
import com.bl.myproject.entity.BlUserExample;
import com.bl.myproject.service.BlUserService;
import com.bl.myproject.util.IntergerUtil;
import com.bl.myproject.util.ResponseResult;
import com.bl.myproject.util.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "后台用户管理接口",description = "后台用户管理接口")
public class UserController {

    @Resource
    private BlUserService service;

    @ApiOperation(value = "获取用户信息",httpMethod = "GET",notes = "根据用户名关键字查询用户列表\n\r这是换行")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "name",dataType = "string",value = "姓名的关键字",defaultValue = "默认"),
            @ApiImplicitParam(paramType="query",name="page",dataType = "int",required = true,value = "第几页",defaultValue = "1"),
            @ApiImplicitParam(paramType="query",name="limit",dataType = "int",required = true,value = "每页显示几条",defaultValue = "10")
    })
    @RequestMapping(value = "/list",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseResult getUserList(String name,Integer page,Integer limit){//方法命名，get/post开始

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
        example.createCriteria().andDelEqualTo(EntityConstant.ONE).andNameLike(StringUtil.getLikeStr(name));
        return service.selectByExample(example);
    }
}
