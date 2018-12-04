package com.meiman.meimanwallet.dao.mapper;

import com.meiman.meimanwallet.entity.MmUserExt;

/**
 * 用户额外信息
 * @author zeng_
 */
public interface MmUserExtMapper {
    /**
     * 保存
     * @param record 用户额外信息对象
     * @return 1成功，0失败
     */
    int insert(MmUserExt record);

    /**
     * 根据主键删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 根据主键查询
     * @param id
     * @return
     */
    MmUserExt selectByPrimaryKey(Integer id);

    /**
     * 根据主键修改
     * @param record
     * @return
     */
    int updateByPrimaryKey(MmUserExt record);
}