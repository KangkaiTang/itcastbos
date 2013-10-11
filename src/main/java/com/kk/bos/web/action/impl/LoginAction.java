package com.kk.bos.web.action.impl;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.kk.bos.domain.User;
import com.kk.bos.web.action.BaseAction;
import com.opensymphony.xwork2.ModelDriven;


public class LoginAction extends BaseAction implements ModelDriven<User>{

	
	private User user = new User();
	private String checkcode;
	
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	
	@Override
	public String execute() throws Exception {
		User loginUser = (User) userService.login(user);
		HttpSession session = ServletActionContext.getRequest().getSession();
		String _checkcode = (String) session.getAttribute("key");
		
		if(!_checkcode.equals(checkcode)) {
			this.addActionError("Validate Code is wrong");
			return INPUT;
		}
		
		if(loginUser!=null) {
			session.setAttribute("user", loginUser);
			return SUCCESS;
		} else {
			this.addActionError("Username/Password is wrong");
			return INPUT;
		}
	}
}
