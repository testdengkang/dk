package com.web.service;

import com.web.model.TUser;

public interface UserService {
    int addUser(TUser user);
    int updateUser(TUser user);
    TUser queryUserByUserName(String userName);

}
