package com.nged.service.impl;

import com.nged.dao.IUserDao;
import com.nged.entity.User;
import com.nged.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service("iUserService")
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserDao userDao;

	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		return this.userDao.selectByPrimaryKey(userId);
	}

}
