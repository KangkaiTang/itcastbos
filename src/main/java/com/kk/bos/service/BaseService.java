package com.kk.bos.service;

import com.kk.bos.dao.IGenericDao;
import com.kk.bos.domain.User;
import com.kk.bos.domain.bc.Standard;

public abstract class BaseService {
	protected IGenericDao<User> userDao;
	
	protected IGenericDao<Standard> standardDao;

	public void setUserDao(IGenericDao<User> userDao) {
		this.userDao = userDao;
	}

	public void setStandardDao(IGenericDao<Standard> standardDao) {
		this.standardDao = standardDao;
	}
	
}
