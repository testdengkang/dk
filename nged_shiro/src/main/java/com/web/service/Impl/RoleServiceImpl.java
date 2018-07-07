package com.web.service.Impl;

import com.web.dao.TRoleMapper;
import com.web.model.TRole;
import com.web.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

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
    public Set<String> queryRolesByUserId(int userId) {
        return tRoleMapper.queryRolesByUserId(userId);
    }

    @Override
    public List<TRole> queryAllRoles() {
        return tRoleMapper.selectAll();
    }
}
