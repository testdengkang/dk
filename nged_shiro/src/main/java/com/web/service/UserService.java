package com.web.service;

import com.web.model.TUser;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    int addUser(TUser user);
    int updateUser(TUser user);
    TUser queryUserByUserName(String userName);
    void batchAddUserWithBatchExcutor(List<TUser> list) throws SQLException;
    void batchAddUserWithXmlForeach(List<TUser> list);

}
