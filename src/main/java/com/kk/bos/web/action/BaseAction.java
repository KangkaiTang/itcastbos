package com.kk.bos.web.action;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.kk.bos.domain.Page;
import com.kk.bos.domain.bc.Standard;
import com.kk.bos.service.IUserService;
import com.kk.bos.service.bc.IRegionService;
import com.kk.bos.service.bc.IStaffService;
import com.kk.bos.service.bc.IStandardService;
import com.kk.bos.service.bc.ISubareaService;
import com.opensymphony.xwork2.ActionSupport;

public abstract class BaseAction extends ActionSupport {
	protected IUserService userService;
	protected IStandardService standardService;
	protected IStaffService staffService;
	protected IRegionService regionService;
	protected ISubareaService subareaService;
	
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public void setStandardService(IStandardService standardService) {
		this.standardService = standardService;
	}

	public void setStaffService(IStaffService staffService) {
		this.staffService = staffService;
	}
	

	public void setRegionService(IRegionService regionService) {
		this.regionService = regionService;
	}
	


	public void setSubareaService(ISubareaService subareaService) {
		this.subareaService = subareaService;
	}


	// 封装pageQuery分页请求
	private int page;
	private int rows;

	public void setPage(int page) {
		this.page = page;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public Page initPage(DetachedCriteria detachedCriteria) {

		// set in request attribute
		Page myPage = new Page();
		myPage.setPageNum(page);
		myPage.setRowPerPage(rows);
		myPage.setDetachedCriteria(detachedCriteria);
		return myPage;
	}

}
