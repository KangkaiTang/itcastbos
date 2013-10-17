package com.kk.bos.web.action.impl.bc;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.crm.domain.Customer;

import com.kk.bos.domain.Page;
import com.kk.bos.domain.bc.DecideZone;
import com.kk.bos.web.action.BaseAction;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

public class DecideZoneAction extends BaseAction implements
		ModelDriven<DecideZone> {

	private DecideZone decideZone = new DecideZone();
	private String[] subareaId;

	// 属性注入
	public void setSubareaId(String[] subareaId) {
		this.subareaId = subareaId;
	}

	@Override
	public DecideZone getModel() {
		// TODO Auto-generated method stub
		return decideZone;
	}

	public String saveOrUpdate() throws Exception {

		decideZoneService.saveOrUpdate(decideZone, subareaId);

		return "saveOrUpdateSuccess";
	}

	public String pageQueryDecideZone() throws Exception {

		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(DecideZone.class);
		Page myPage = initPage(detachedCriteria);
		Page returnPage = decideZoneService.pageQuery(myPage);
		ActionContext.getContext().put("returnPage", returnPage);
		return "pageQueryDecideZoneSuccess";
	}

	/*
	 * hessian
	 */

	public String listUnascCustomer() throws Exception {

		List<Customer> customers = customerService.listUnascCustomer();
		ActionContext.getContext().put("customers", customers);

		return "listUnascCustomerSuccess";
	}

	public String listHsascCustomer() throws Exception {

		List<Customer> customers = customerService
				.listHsascCustomer(decideZone.getId());
		ActionContext.getContext().put("customers", customers);

		return "listHsascCustomerSuccess";
	}
	
	
	//属性注入
	private String[] customerIds;

	public void setCustomerIds(String[] customerIds) {
		this.customerIds = customerIds;
	}

	public String associate() throws Exception {
		if(customerIds!=null) {
	
			customerService.associate(customerIds, decideZone.getId());
		}
		return "associateSuccess";
	}
}
