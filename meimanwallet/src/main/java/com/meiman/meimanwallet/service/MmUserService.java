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
}
