package com.bl.myproject.service;

import com.bl.myproject.util.ResponseResult;

import java.io.Serializable;
import java.util.List;

/**
 * @author bl
 * @date 2019-5-24
 */
public interface BaseService<M,E,ID extends Serializable> {

    /**
     * 根据example查询数量
     * @param example example
     * @return 查询结果数量
     */
    ResponseResult countByExample(E example);

    /**
     * 根据主键真删除
     * @param id 主键
     * @return 删除结果
     */
    ResponseResult deleteById(ID id);

    /**
     * 保存对象
     * @param entity 对象
     * @return 保存结果
     */
    ResponseResult insert(M entity);

    /**
     * 根据模板对象查询符合的对象集合
     * @param example 模板对象
     * @return 根据模板查询结果集合
     */
    ResponseResult<List<M>> selectByExample(E example);

    /**
     * 根据主键查询
     * @param id 主键
     * @return 查询结果
     */
    ResponseResult selectById(ID id);

    /**
     * 修改对象
     * @param entity 对象
     * @return 修改结果
     */
    ResponseResult updateBySelective(M entity);

    /**
     * 根据主键修改删除状态
     * @param id 主键
     * @return 修改删除状态结果
     */
    ResponseResult delByStu(ID id);

}
