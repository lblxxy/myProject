package com.bl.myproject.service;

import com.bl.myproject.entity.BlUser;
import com.bl.myproject.entity.BlUserExample;
import com.bl.myproject.util.ResponseResult;

/**
 * @author bl
 * @date 2019-5-24
 */
public interface BlUserService extends BaseService<BlUser, BlUserExample,Integer>{
    /**
     * 用户登录
     * @param userName 用户名
     * @param pwd 密码
     * @return 登录结果
     */
    ResponseResult login(String userName, String pwd);
}
