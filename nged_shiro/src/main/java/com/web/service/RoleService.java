package com.web.service;

import com.web.model.TRole;

import java.util.List;


public interface RoleService {
    int addRole(TRole role);
    int updateRole(TRole role);
    List<TRole> queryRolesByUserId(int userId);
}
