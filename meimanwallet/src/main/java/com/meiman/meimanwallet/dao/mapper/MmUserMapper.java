package com.meiman.meimanwallet.dao.mapper;

import com.meiman.meimanwallet.entity.MmUser;

/**
 * 用户
 * @author zeng_
 */
public interface MmUserMapper {
    /**
     * 根据主键删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 根据主键插入
     * @param record
     * @return
     */
    int insert(MmUser record);

    /**
     * 根据主键查询
     * @param id
     * @return
     */
    MmUser selectByPrimaryKey(Integer id);

    /**
     * 根据主键修改
     * @param record
     * @return
     */
    int updateByPrimaryKey(MmUser record);
}