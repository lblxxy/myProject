package com.meiman.meimanwallet.impl;

import com.meiman.meimanwallet.constant.ErrorCodeMsg;
import com.meiman.meimanwallet.dao.mapper.MmUserMapper;
import com.meiman.meimanwallet.entity.MmUser;
import com.meiman.meimanwallet.service.MmUserService;
import com.meiman.meimanwallet.utils.RpcClientResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zeng_
 */
@Service("mmUserService")
public class MmUserServiceImpl implements MmUserService {

    @Resource
    private MmUserMapper mmUserMapper;

    /**
     * 根据主键，查询用户信息
     * @param id 主键
     * @return 查询结果集
     */
    @Override
    @SuppressWarnings("unchecked")
    public RpcClientResult selectByPrimaryKey(Integer id) {
        //验证参数是否正常
        if(null == id || id <= 0){
            return RpcClientResult.getFailed(ErrorCodeMsg.NULL_PARAMETER);
        }
        MmUser mmUser = mmUserMapper.selectByPrimaryKey(id);
        //是否是正确的用户id
        if(null == mmUser){
            return RpcClientResult.getFailed(ErrorCodeMsg.NULL_PARAMETER);
        }
        RpcClientResult<MmUser> result = RpcClientResult.getSuccess();
        result.setData(mmUser);
        return result;
    }
}
