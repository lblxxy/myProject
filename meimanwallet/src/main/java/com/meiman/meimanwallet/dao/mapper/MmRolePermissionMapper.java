package com.meiman.meimanwallet.dao.mapper;

import com.meiman.meimanwallet.entity.MmRolePermission;

/**
 * @author zeng_
 */
public interface MmRolePermissionMapper {
    /**
     * 根据主键删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 根据对象保存
     * @param record
     * @return
     */
    int insert(MmRolePermission record);

    /**
     * 根据主键查询
     * @param id
     * @return
     */
    MmRolePermission selectByPrimaryKey(Integer id);

    /**
     * 根据主键修改
     * @param record
     * @return
     */
    int updateByPrimaryKey(MmRolePermission record);
}