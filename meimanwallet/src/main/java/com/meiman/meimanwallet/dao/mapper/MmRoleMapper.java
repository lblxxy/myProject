package com.meiman.meimanwallet.dao.mapper;

import com.meiman.meimanwallet.entity.MmRole;

/**
 * 用户角色信息
 * @author zeng_
 */
public interface MmRoleMapper {
    /**
     * 根据主键删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 根据对象插入
     * @param record
     * @return
     */
    int insert(MmRole record);

    /**
     * 根据主键查询
     * @param id
     * @return
     */
    MmRole selectByPrimaryKey(Integer id);

    /**
     * 根据主键修改
     * @param record
     * @return
     */
    int updateByPrimaryKey(MmRole record);
}