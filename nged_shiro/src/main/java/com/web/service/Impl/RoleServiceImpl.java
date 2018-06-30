package com.web.service.Impl;

import com.web.dao.TRoleMapper;
import com.web.model.TRole;
import com.web.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private TRoleMapper tRoleMapper;

    @Override
    public int addRole(TRole role) {
        return tRoleMapper.insert(role);
    }

    @Override
    public int updateRole(TRole role) {
        return tRoleMapper.updateByPrimaryKey(role);
    }

    @Override
    public List<TRole> queryRolesByUserId(int userId) {
        return tRoleMapper.queryRolesByUserId(userId);
    }
}
