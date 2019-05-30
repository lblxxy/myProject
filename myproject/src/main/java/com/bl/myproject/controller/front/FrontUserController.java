package com.bl.myproject.controller.front;
/**
 * @author bl
 * @date 2019-5-27
 */

import com.bl.myproject.service.BlUserService;
import com.bl.myproject.util.ResponseResult;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author bl
 * @date 2019-5-24
 */
@RestController
@RequestMapping("/user")
@Api(value = "用户前端接口",description = "用户前端接口")
public class FrontUserController {
    @Resource
    private BlUserService service;

    @ApiOperation(value = "根据用户id获取用户信息",httpMethod = "GET",notes = "id:用户id")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path",name = "uid",dataType = "int",value = "用户id",required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 1000,message = "查询成功！"),
            @ApiResponse(code = 10003,message = "用户主键为空！"),
    })
    @RequestMapping(value = "/getUserInfo/{uid}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseResult getUserInfo(@PathVariable Integer uid){//请求路径携带参数
        return service.selectById(uid);
    }

    @ApiOperation(value = "用户登录",httpMethod = "POST",notes = "用户登录")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "userName",required = true,dataType = "string",value = "用户名"),
            @ApiImplicitParam(paramType = "query",name = "pwd",required = true,dataType = "string",value = "用户密码"),
    })
    @ApiResponses({
            @ApiResponse(code = 1000,message = "登录成功！"),
            @ApiResponse(code = 10003,message = "登录失败！"),
    })
    @RequestMapping(value = "/login",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseResult postLogin(String userName,String pwd){
        return service.login(userName,pwd);
    }
}
