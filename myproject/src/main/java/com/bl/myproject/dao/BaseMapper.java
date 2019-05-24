package com.bl.myproject.dao;

import java.io.Serializable;
import java.util.List;

/**
 * 基类mybatis接口
 * @author bl
 * @date 2019/5/24
 * @param <M> 实体对象
 * @param <E> 条件查询模板
 * @param <ID> 主键
 */
public interface BaseMapper<M,E,ID extends Serializable> {
    int countByExample(E example);

    int deleteByPrimaryKey(Integer id);

    int insert(M record);

    int insertSelective(M record);

    List<M> selectByExample(E example);

    M selectByPrimaryKey(ID id);

    int updateByPrimaryKeySelective(M record);

    int updateByPrimaryKey(M record);

    int delByStu(Integer integer);
}
