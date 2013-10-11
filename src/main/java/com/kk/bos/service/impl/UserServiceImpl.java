package com.kk.bos.service.impl;

import java.util.List;

import com.kk.bos.domain.User;
import com.kk.bos.service.BaseService;
import com.kk.bos.service.IUserService;
import com.kk.bos.utils.MD5Utils;

public class UserServiceImpl extends BaseService implements IUserService {

	@Override
	public User login(User user) {
		List<User> lst = userDao.findByNamedQuery("login", user.getUsername(),
				MD5Utils.md5(user.getPassword()));
		return lst.isEmpty()?null:lst.get(0);
	}

	@Override
	public void editPassword(User loginUser, String password) {
		User user = userDao.findById(loginUser.getId());
		user.setPassword(MD5Utils.md5(password));
	}

}
