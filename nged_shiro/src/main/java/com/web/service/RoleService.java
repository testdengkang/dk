package com.web.service;

import com.web.model.TRole;

import java.util.List;
import java.util.Set;


public interface RoleService {
    int addRole(TRole role);
    int updateRole(TRole role);
    Set<String> queryRolesByUserId(int userId);
}
