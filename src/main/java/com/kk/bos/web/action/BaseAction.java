package com.kk.bos.web.action;

import com.kk.bos.service.IUserService;
import com.kk.bos.service.bc.IStandardService;
import com.opensymphony.xwork2.ActionSupport;

public abstract class BaseAction extends ActionSupport {
	protected IUserService userService;
	protected IStandardService standardService;

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public void setStandardService(IStandardService standardService) {
		this.standardService = standardService;
	}
	
	

}
