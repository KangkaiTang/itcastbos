package com.kk.bos.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;

import cn.itcast.crm.service.ICustomerService;

import com.kk.bos.dao.IGenericDao;
import com.kk.bos.domain.Page;
import com.kk.bos.domain.User;
import com.kk.bos.domain.bc.DecideZone;
import com.kk.bos.domain.bc.Region;
import com.kk.bos.domain.bc.Staff;
import com.kk.bos.domain.bc.Standard;
import com.kk.bos.domain.bc.Subarea;
import com.kk.bos.domain.qp.NoticeBill;
import com.kk.bos.domain.qp.WorkBill;
import com.kk.bos.domain.qp.WorkOrderManage;

public abstract class BaseService {
	protected IGenericDao<User> userDao;

	protected IGenericDao<Standard> standardDao;

	protected IGenericDao<Staff> staffDao;

	protected IGenericDao<Region> regionDao;

	protected IGenericDao<Subarea> subareaDao;

	protected IGenericDao<DecideZone> decideZoneDao;

	// 业务受理
	protected IGenericDao<NoticeBill> noticeBillDao;

	protected ICustomerService customerService;

	protected IGenericDao<WorkBill> workBillDao;

	protected IGenericDao<WorkOrderManage> workOrderManageDao;

	public void setUserDao(IGenericDao<User> userDao) {
		this.userDao = userDao;
	}

	public void setStandardDao(IGenericDao<Standard> standardDao) {
		this.standardDao = standardDao;
	}

	public void setStaffDao(IGenericDao<Staff> staffDao) {
		this.staffDao = staffDao;
	}

	public void setRegionDao(IGenericDao<Region> regionDao) {
		this.regionDao = regionDao;
	}

	public void setSubareaDao(IGenericDao<Subarea> subareaDao) {
		this.subareaDao = subareaDao;
	}

	public void setDecideZoneDao(IGenericDao<DecideZone> decideZoneDao) {
		this.decideZoneDao = decideZoneDao;
	}

	public void setNoticeBillDao(IGenericDao<NoticeBill> noticeBillDao) {
		this.noticeBillDao = noticeBillDao;
	}

	public void setCustomerService(ICustomerService customerService) {
		this.customerService = customerService;
	}

	public void setWorkBillDao(IGenericDao<WorkBill> workBillDao) {
		this.workBillDao = workBillDao;
	}

	public void setWorkOrderManageDao(
			IGenericDao<WorkOrderManage> workOrderManageDao) {
		this.workOrderManageDao = workOrderManageDao;
	}

	// 分页通用代码
	public <T> Page pageQuery(Page myPage, IGenericDao<T> dao) {
		/*
		 * set in response attribute private List rows; private int totalPage;
		 */
		System.out.println("Page: " + myPage.getPageNum());
		System.out.println("Rows: " + myPage.getRowPerPage());

		DetachedCriteria detachedCriteria = myPage.getDetachedCriteria();

		// 1. rows
		// detachedCriteria.setProjection(null);
		int firstResult = (myPage.getPageNum() - 1) * myPage.getRowPerPage();
		int maxResults = myPage.getRowPerPage();
		List<T> rows = dao.pageQuery(detachedCriteria, firstResult, maxResults);
		myPage.setRows(rows);

		// 2. totalPage
		detachedCriteria.setProjection(Projections.rowCount());
		List lst = dao.pageQuery(detachedCriteria, 0, 1);
		// List<T> lst = dao.pageQuery(detachedCriteria, 0, 1);
		myPage.setTotal((Long) lst.get(0));
		return myPage;
	}

}
