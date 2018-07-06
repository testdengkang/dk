package com.web.service.Impl;

import com.web.dao.TPermissionMapper;
import com.web.model.TPermission;
import com.web.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private TPermissionMapper tPermissionMapper;

    @Override
    public int addPermission(TPermission permission) {
        return tPermissionMapper.insert(permission);
    }

    @Override
    public int updatePermission(TPermission permission) {
        return tPermissionMapper.updateByPrimaryKey(permission);
    }

    @Override
    public Set<String> queryPermissionsByUserId(int userId) {
        return tPermissionMapper.queryPermissionsByUserId(userId);
    }
}
