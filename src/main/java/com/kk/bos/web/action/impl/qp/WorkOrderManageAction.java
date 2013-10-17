package com.kk.bos.web.action.impl.qp;

import org.hibernate.criterion.DetachedCriteria;

import com.kk.bos.domain.Page;
import com.kk.bos.domain.qp.WorkOrderManage;
import com.kk.bos.web.action.BaseAction;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

public class WorkOrderManageAction extends BaseAction implements
		ModelDriven<WorkOrderManage> {

	WorkOrderManage workOrderManage = new WorkOrderManage();
	
	@Override
	public WorkOrderManage getModel() {
		// TODO Auto-generated method stub
		return workOrderManage;
	}
	
	public String saveOrUpdate() throws Exception {
		
		workOrderManageService.saveOrUpdate(workOrderManage);
		
		return "saveOrUpdateSuccess";
	}
	
	
	//属性注入
	private String conditionName;
	private String conditionValue;
	
	
	public void setConditionName(String conditionName) {
		this.conditionName = conditionName;
	}

	public void setConditionValue(String conditionValue) {
		this.conditionValue = conditionValue;
	}

	public String pageQuery() throws Exception {
		
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(WorkOrderManage.class);
		Page myPage = initPage(detachedCriteria);
		Page returnPage = null;
		
		if(conditionValue == null || !(conditionValue.trim().length() > 0)) {
			returnPage = workOrderManageService.pageQuery(myPage);
		} else {
			returnPage = workOrderManageService.queryByLucene(conditionName, conditionValue, myPage);
		}
		ActionContext.getContext().put("returnPage", returnPage);
		return "pageQuerySuccess";
	}

}
