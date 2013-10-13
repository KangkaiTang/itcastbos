package com.kk.bos.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;

import com.kk.bos.dao.IGenericDao;
import com.kk.bos.domain.Page;
import com.kk.bos.domain.User;
import com.kk.bos.domain.bc.Staff;
import com.kk.bos.domain.bc.Standard;

public abstract class BaseService {
	protected IGenericDao<User> userDao;

	protected IGenericDao<Standard> standardDao;

	protected IGenericDao<Staff> staffDao;

	public void setUserDao(IGenericDao<User> userDao) {
		this.userDao = userDao;
	}

	public void setStandardDao(IGenericDao<Standard> standardDao) {
		this.standardDao = standardDao;
	}

	public void setStaffDao(IGenericDao<Staff> staffDao) {
		this.staffDao = staffDao;
	}

	// 分页通用代码
	public <T> Page pageQuery(Page myPage, IGenericDao<T> dao) {
		/*
		 * set in response attribute private List rows; private int totalPage;
		 */

		// 1. totalPage
		DetachedCriteria detachedCriteria = myPage.getDetachedCriteria();
		detachedCriteria.setProjection(Projections.rowCount());
		List lst = dao.findByCriteria(detachedCriteria);
		myPage.setTotal((Long) lst.get(0));

		// 2. rows
		detachedCriteria.setProjection(null);
		int firstResult = (myPage.getPageNum() - 1) * myPage.getRowPerPage();
		int maxResults = myPage.getRowPerPage();
		List<T> rows = dao.pageQuery(detachedCriteria, firstResult, maxResults);
		myPage.setRows(rows);

		return myPage;
	}

}
