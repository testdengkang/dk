package com.web.dao;

import com.web.model.TUser;
import java.util.List;

public interface TUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_USER
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_USER
     *
     * @mbggenerated
     */
    int insert(TUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_USER
     *
     * @mbggenerated
     */
    TUser selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_USER
     *
     * @mbggenerated
     */
    List<TUser> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_USER
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(TUser record);

    /**
     * 根据userName 查询用户
     * @param userName
     * @return
     */
    TUser queryUserByUserName(String userName);
}