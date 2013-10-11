package com.kk.bos.web.action.impl.bc;

import java.sql.Timestamp;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.kk.bos.domain.Page;
import com.kk.bos.domain.User;
import com.kk.bos.domain.bc.Standard;
import com.kk.bos.web.action.BaseAction;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

public class StandardAction extends BaseAction implements ModelDriven<Standard> {

	private Standard standard = new Standard();

	// page的属性注入
	private int page;
	private int rows;

	@Override
	public Standard getModel() {
		// TODO Auto-generated method stub
		return standard;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public String saveupdate() throws Exception {
		User loginUser = (User) ServletActionContext.getRequest().getSession()
				.getAttribute("user");
		
		standard.setUser(loginUser);
		standard.setUpdatetime(new Timestamp(System.currentTimeMillis()));

		standardService.saveOrUpdate(standard);
		return "saveupdateSuccess";
	}

	public String pageQuery() throws Exception {
		//set in request attribute
		Page myPage = new Page();
		myPage.setPageNum(page);
		myPage.setRowPerPage(rows);
		
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Standard.class);
		detachedCriteria.add(Restrictions.eq("deltag", "0"));
		myPage.setDetachedCriteria(detachedCriteria);
		
		Page returnPage = standardService.pageQuery(myPage);
		ActionContext.getContext().put("returnPage", returnPage);
		
		return "pageQuerySuccess";
	}
	
	
	public String deleteBatch() throws Exception {
		String[] ids = standard.getId().split(", ");
		
		standardService.deleteBatch(ids);
		
		return "deleteSuccess";
	}

}
