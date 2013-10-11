package com.kk.bos.web.interceptor;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.kk.bos.domain.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.sun.tools.doclets.internal.toolkit.util.DocFinder.Input;

public class LoginInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		User loginUser = (User)session.getAttribute("user");
		if(loginUser == null) {
			((ActionSupport)invocation.getAction()).addActionError("Please login first");
			return "login";
		} else{
			return invocation.invoke();
		}
		
	}

}
