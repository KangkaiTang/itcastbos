package com.kk.bos.web.action.impl.qp;

import org.apache.struts2.ServletActionContext;

import com.kk.bos.domain.User;
import com.kk.bos.domain.qp.NoticeBill;
import com.kk.bos.web.action.BaseAction;
import com.opensymphony.xwork2.ModelDriven;

public class NoticeBillAction extends BaseAction implements
		ModelDriven<NoticeBill> {

	private NoticeBill noticeBill = new NoticeBill();
	
	@Override
	public NoticeBill getModel() {
		// TODO Auto-generated method stub
		return noticeBill;
	}
	
	public String save() throws Exception {
		User user = (User)ServletActionContext.getRequest().getSession().getAttribute("user");
		noticeBill.setUser(user);
		noticeBillSerivce.save(noticeBill);
		return "saveSuccess";
	}

}
