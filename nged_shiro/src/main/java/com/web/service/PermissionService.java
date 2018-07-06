package com.web.service;

import com.web.model.TPermission;

import java.util.List;
import java.util.Set;

public interface PermissionService  {
    int addPermission(TPermission permission);
    int updatePermission(TPermission permission);
    Set<String> queryPermissionsByUserId(int userId);
}
