package com.meiman.meimanwallet.dao.mapper;

import com.meiman.meimanwallet.entity.MmPermission;

/**
 * 用户权限信息
 * @author zeng_
 */
public interface MmPermissionMapper {
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
    int insert(MmPermission record);

    /**
     * 根据主键查询
     * @param id
     * @return
     */
    MmPermission selectByPrimaryKey(Integer id);

    /**
     * 根据主键修改
     * @param record
     * @return
     */
    int updateByPrimaryKey(MmPermission record);
}