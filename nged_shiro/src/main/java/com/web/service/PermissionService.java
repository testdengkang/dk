package com.web.service;

import com.web.model.TPermission;

import java.util.List;

public interface PermissionService  {
    int addPermission(TPermission permission);
    int updatePermission(TPermission permission);
    List<TPermission> queryPermissionsByUserId(int userId);
}
