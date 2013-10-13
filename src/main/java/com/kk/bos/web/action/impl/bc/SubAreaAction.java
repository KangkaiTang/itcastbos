package com.kk.bos.web.action.impl.bc;

import org.hibernate.criterion.DetachedCriteria;

import com.kk.bos.domain.Page;
import com.kk.bos.domain.bc.Subarea;
import com.kk.bos.web.action.BaseAction;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

public class SubAreaAction extends BaseAction implements ModelDriven<Subarea>{

	Subarea subarea = new Subarea();
	@Override
	public Subarea getModel() {
		// TODO Auto-generated method stub
		return subarea;
	}
	
	public String saveOrUpdate() throws Exception {
		
		subareaService.saveOrUpdate(subarea);
		return "saveOrUpdateSuccess";
	}
	
	public String listAll() throws Exception {
		
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Subarea.class);
		Page myPage = initPage(detachedCriteria);
		
		Page returnPage = subareaService.pageQuery(myPage);
		ActionContext.getContext().put("returnPage", returnPage);
		
		return "listAllSuccess";
	}
	
}
