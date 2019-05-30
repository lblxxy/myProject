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
    /**
     * 根据example查询数量
     * @param example example
     * @return 查询结果数量
     */
    int countByExample(E example);
    /**
     * 根据主键真删除
     * @param id 主键
     * @return 删除结果
     */
    int deleteByPrimaryKey(Integer id);
    /**
     * 保存对象
     * @param record 对象
     * @return 保存结果
     */
    int insert(M record);

    /**
     * 保存对象，要判空，就是数据不传完，只添加传了的字段
     * @param record 对象
     * @return 保存结果
     */
    int insertSelective(M record);
    /**
     * 根据模板对象查询符合的对象集合
     * @param example 模板对象
     * @return 根据模板查询结果集合
     */
    List<M> selectByExample(E example);

    /**
     * 根据主键查询对象
     * @param id 主键
     * @return 查询结果
     */
    M selectByPrimaryKey(ID id);

    /**
     * 修改对象，判空
     * @param record 对象
     * @return 修改结果
     */
    int updateByPrimaryKeySelective(M record);

    /**
     * 根据主键修改 不判空
     * @param record 对象
     * @return 修改结果
     */
    int updateByPrimaryKey(M record);
    /**
     * 根据主键修改删除状态
     * @param id 主键
     * @return 修改删除状态结果
     */
    int delByStu(Integer id);
}
