package com.bl.myproject.impl;

import com.bl.myproject.constant.Constant;
import com.bl.myproject.constant.EntityConstant;
import com.bl.myproject.constant.ErrorCode;
import com.bl.myproject.dao.BlUserMapper;
import com.bl.myproject.entity.BlUser;
import com.bl.myproject.entity.BlUserExample;
import com.bl.myproject.service.BaseService;
import com.bl.myproject.service.BlUserService;
import com.bl.myproject.util.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
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

    @Override
    public ResponseResult login(String userName, String pwd) {
        //验证用户名
        if(StringUtil.isBlank(userName)){
            return ResponseResult.getFailed(ErrorCode.NULL_USERNAME);
        }
        //验证密码
        if(StringUtil.isBlank(pwd)){
            return ResponseResult.getFailed(ErrorCode.NULL_PWD);
        }
        //验证密码长度在6到32之间
        if(!StringUtil.checkPwdLength(pwd)){
            return ResponseResult.getFailed(ErrorCode.PWD_LENGTH_ERROR);
        }
        BlUser user  = selectByLoginName(userName);
        ResponseResult result = new ResponseResult();
        if(null != user){
            //密码验证不通过，这里使用MD5或者其他进行现场加密，验证，和库中的加密过后的进行对比
            if(!MD5Util.encodeByMD5(pwd).equals(user.getPwd())){
                return ResponseResult.getFailed(ErrorCode.PWD_IS_ERROR);
            }
            result.setSuccess(true,ErrorCode.SUCCESS);
            //密码验证通过：可以根据不同的系统来源，存入不同的缓存，是用不同来源的标记和登录的类型等，拼接组成缓存key的一部分，同时存入对象，设置过期时间
            RedisUtil.getInstance().set(Constant.WEB_NAME,Constant.USER_LOGIN,user,EntityConstant.DEFAULT_REDIS_TIME);
            Map<String,Object> map = new HashMap<>(EntityConstant.TWO);
            //todo 这里会redis里面对象有一个乱码问题,但是读去取出来又没问题,原因应该是存的时候是存的，btye[]，
            map.put("id",user.getId());
            map.put("name",user.getName());
            map.put("age",user.getAge());
            map.put("sex",user.getSex());
            result.setData(map);
            System.out.println(RedisUtil.getInstance().get(Constant.WEB_NAME,Constant.USER_LOGIN));
            return result;
        }
        return ResponseResult.getFailed(ErrorCode.USER_OR_PWD_ERROR);
    }

    /**
     * 根据用户名查询用户信息
     * @param userName 用户名
     * @return 用户信息
     */
    private BlUser selectByLoginName(String userName) {
        if(StringUtil.isBlank(userName)){
            return null;
        }
        BlUserExample userExample = new BlUserExample();
        BlUserExample.Criteria userExampleCriteria = userExample.createCriteria();
        userExampleCriteria.andNameEqualTo(userName);
        List<BlUser> blUsers = mapper.selectByExample(userExample);
        if(null != blUsers && blUsers.size()>0){
            return blUsers.get(0);
        }
        return null;
    }
}
