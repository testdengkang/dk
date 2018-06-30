package com.web.dao;

import com.web.model.TPermission;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TPermissionMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(TPermission record);


    TPermission selectByPrimaryKey(Integer id);

    List<TPermission> selectAll();


    int updateByPrimaryKey(TPermission record);

    List<TPermission> queryPermissionsByUserId(int userId);
}