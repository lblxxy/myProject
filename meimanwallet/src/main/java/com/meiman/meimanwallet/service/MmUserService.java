package com.meiman.meimanwallet.service;

import com.meiman.meimanwallet.utils.RpcClientResult;

/**
 * 用户service
 * @author zeng_
 * @Date 2018/12/3
 */
public interface MmUserService {
    /**
     * 根据主键查询用户
     * @param id 主键
     * @return 返回rpcClientResult
     */
    RpcClientResult selectByPrimaryKey(Integer id);

    /**
     * 根据条件查询用户
     * @param stu  状态
     * @param start  分页开始页数
     * @param end  分页结束页数
     * @param rank 等级
     * @param role 角色
     * @param name 姓名
     * @return 查询结果
     */
    RpcClientResult selectList(Integer start,Integer end,Integer stu,Integer rank,Integer role,String name);

    /**
     * 根据条件查询数据条数
     * @param stu
     * @param rank
     * @param role
     * @param name
     * @return
     */
    Integer selectListCount(Integer stu,Integer rank,Integer role,String name);
}
