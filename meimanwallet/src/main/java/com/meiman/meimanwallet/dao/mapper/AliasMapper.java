package com.meiman.meimanwallet.dao.mapper;

import com.meiman.meimanwallet.entity.Alias;

/**
 * @author zeng_
 * @Date 2018/11/27
 */
public interface AliasMapper {

    /**
     * 根据主键查询
     * @param id
     * @return
     */
    Alias selectByPrimaryKey(String id);}
