package com.bl.myproject.impl;

import com.bl.myproject.constant.EntityConstant;
import com.bl.myproject.constant.ErrorCode;
import com.bl.myproject.dao.BlUserMapper;
import com.bl.myproject.entity.BlUser;
import com.bl.myproject.entity.BlUserExample;
import com.bl.myproject.service.BaseService;
import com.bl.myproject.service.BlUserService;
import com.bl.myproject.util.IntergerUtil;
import com.bl.myproject.util.ResponseResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author bl
 * @date 2019-5-24
 */
@Service
public class BlUserServiceImpl implements BlUserService {

    @Resource
    private BlUserMapper mapper;

    @Override
    @SuppressWarnings("unchecked")
    public ResponseResult countByExample(BlUserExample example) {
        ResponseResult result = ResponseResult.getSuccess();
        result.setData(mapper.countByExample(example));
        return result;
    }

    @Override
    public ResponseResult deleteById(Integer integer) {
        if(!IntergerUtil.isNaturalNumber(integer)){
            return ResponseResult.getFailed(ErrorCode.PARAMETER_ERROR);
        }
        if(mapper.deleteByPrimaryKey(integer)== EntityConstant.MYBATIS_SUCCESS){
            return ResponseResult.getSuccess();
        }
        return ResponseResult.getFailed(ErrorCode.MYBATIS_ERROR);
    }

    @Override
    public ResponseResult insert(BlUser entity) {
        //todo 参数验证
        if(null==entity){
            return ResponseResult.getFailed(ErrorCode.PARAMETER_ERROR);
        }
        if(mapper.insert(entity) == EntityConstant.MYBATIS_SUCCESS){
            return ResponseResult.getSuccess();
        }
        return ResponseResult.getFailed(ErrorCode.MYBATIS_ERROR);
    }

    @Override
    @SuppressWarnings("unchecked")
    public ResponseResult selectByExample(BlUserExample example) {
        ResponseResult result = countByExample(example);
        if(result.isSuccess()){
            Map<String,Object> map = new HashMap<>(EntityConstant.TWO);
            map.put("list",mapper.selectByExample(example));
            map.put("count",result.getData());
            result.setData(map);
            return result;
        }
        return ResponseResult.getFailed(ErrorCode.NULL_PARAMETER);
    }

    @Override
    @SuppressWarnings("unchecked")
    public ResponseResult selectById(Integer id) {
        if(!IntergerUtil.isNaturalNumber(id)){
            return ResponseResult.getFailed(ErrorCode.NULL_PARAMETER);
        }
        BlUser entity = mapper.selectByPrimaryKey(id);
        ResponseResult result = ResponseResult.getSuccess();
        result.setData(entity);
        return result;
    }

    @Override
    public ResponseResult updateBySelective(BlUser entity) {
        if(mapper.updateByPrimaryKey(entity) == EntityConstant.MYBATIS_SUCCESS){
            return ResponseResult.getSuccess();
        }
        return ResponseResult.getFailed(ErrorCode.NULL_PARAMETER);
    }

    @Override
    public ResponseResult delByStu(Integer integer) {
        if(!IntergerUtil.isNaturalNumber(integer)){
            return ResponseResult.getFailed(ErrorCode.PARAMETER_ERROR);
        }
        if(mapper.delByStu(integer)==EntityConstant.MYBATIS_SUCCESS){
            return ResponseResult.getSuccess();
        }
        return ResponseResult.getFailed();
    }
}
