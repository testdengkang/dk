package com.web.dao;

import com.web.model.TRole;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TRoleMapper {

    int deleteByPrimaryKey(Integer id);


    int insert(TRole record);


    TRole selectByPrimaryKey(Integer id);


    List<TRole> selectAll();


    int updateByPrimaryKey(TRole record);

    List<TRole> queryRolesByUserId(int userId);
}