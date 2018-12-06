package com.meiman.meimanwallet.dao.mapper;

import com.meiman.meimanwallet.entity.MmUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    /**
     * 分页查询用户信息
     * @param start
     * @param end
     * @param stu
     * @param rank
     * @param role
     * @param name
     * @return
     */
    List<MmUser> selectList(@Param("start")Integer start, @Param("end")Integer end, @Param("stu")Integer stu, @Param("rank")Integer rank, @Param("role")Integer role, @Param("name")String name);

    /**
     * 查询总条数
     * @param stu
     * @param rank
     * @param role
     * @param name
     * @return
     */
    Integer selectListCount(@Param("stu")Integer stu, @Param("rank")Integer rank, @Param("role")Integer role, @Param("name")String name);
}