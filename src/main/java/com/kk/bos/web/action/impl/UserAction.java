package com.kk.bos.web.action.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.kk.bos.domain.User;
import com.kk.bos.web.action.BaseAction;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends BaseAction implements ModelDriven<User> {

	private User user = new User();
	
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	
	
	
	public String editpassword() throws Exception {
		System.out.println("===Edit Password===");
		User loginUser = (User)ServletActionContext.getRequest().getSession().getAttribute("user");
		try{
			userService.editPassword(loginUser, user.getPassword());
			System.out.println("===Edit===");
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("result", "success");
			map.put("msg","successfully change the password");
			ActionContext.getContext().put("map", map);
			
		}catch(Exception e) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("result", "failure");
			map.put("msg","changing password failed");
			ActionContext.getContext().put("map", map);
		}
		return "editSuccess";
	}

}
