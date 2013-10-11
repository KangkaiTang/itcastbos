package com.kk.bos.service;

import com.kk.bos.domain.User;

public interface IUserService {

	public User login(User user);

	public void editPassword(User loginUser, String password);
	
}
