package com.web.service.Impl;

import com.web.dao.TUserMapper;
import com.web.model.TUser;
import com.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private TUserMapper tUserMapper;

    @Override
    public int addUser(TUser user) {
        return tUserMapper.insert(user);
    }

    @Override
    public int updateUser(TUser user) {
        return tUserMapper.updateByPrimaryKey(user);
    }

    @Override
    public TUser queryUserByUserName(String userName) {
        return tUserMapper.queryUserByUserName(userName);
    }


}
