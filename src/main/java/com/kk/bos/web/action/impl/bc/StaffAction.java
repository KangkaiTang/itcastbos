package com.kk.bos.web.action.impl.bc;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;

import com.kk.bos.domain.Page;
import com.kk.bos.domain.bc.Staff;
import com.kk.bos.web.action.BaseAction;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

public class StaffAction extends BaseAction implements ModelDriven<Staff> {

	Staff staff = new Staff();
	@Override
	public Staff getModel() {
		// TODO Auto-generated method stub
		return staff;
	}
	
	public String saveOrUpdate() throws Exception {
		staffService.saveOrUpdate(staff);
		return "saveOrUpdateSuccess";
	}
	
	public String listAllStaff() throws Exception {
		
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Staff.class);
		Page myPage = initPage(detachedCriteria);
		Page returnPage = staffService.pageQuery(myPage);
		ActionContext.getContext().put("returnPage", returnPage);
		
		return "listAllStaffSuccess";
	}
	
	
	
	public String deleteBatch() throws Exception {
		
		String[] staffIds = staff.getId().split(", ");
		
		staffService.changeStatusBatch(staffIds, "1");
		
		return "changeStatusBatchSuccess";
	}
	
	
	public String recoverBatch() throws Exception {
		
		String[] staffIds = staff.getId().split(", ");
		
		staffService.changeStatusBatch(staffIds, "0");
		
		return "changeStatusBatchSuccess";
	}
	
	public String ajaxlist() throws Exception {
		
		List<Staff> staffs = staffService.findAllStaffs();
		ServletActionContext.getContext().put("staffs", staffs);
		
		return "ajaxlistSuccess";
	}
	
}
