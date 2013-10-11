package com.kk.bos.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;

import com.kk.bos.domain.Page;
import com.kk.bos.domain.bc.Standard;
import com.kk.bos.service.BaseService;
import com.kk.bos.service.bc.IStandardService;

public class StandardServiceImpl extends BaseService implements IStandardService{

	@Override
	public void saveOrUpdate(Standard standard) {
		standardDao.saveOrUpdate(standard);
		
	}

	@Override
	public Page pageQuery(Page myPage) {
		/*
		 *  set in response attribute
		  	private List rows;
			private int totalPage;
		 */
		
		//1. totalPage
		DetachedCriteria detachedCriteria = myPage.getDetachedCriteria();
		detachedCriteria.setProjection(Projections.rowCount());
		List lst = standardDao.findByCriteria(detachedCriteria);
		myPage.setTotal((Long) lst.get(0));
		//myPage.setTotal(20);
		
		//2. rows
		detachedCriteria.setProjection(null);
		int firstResult = (myPage.getPageNum() - 1) * myPage.getRowPerPage();
		int maxResults = myPage.getRowPerPage();
		List<Standard> rows = standardDao.pageQuery(detachedCriteria, firstResult, maxResults);
		myPage.setRows(rows);
		
		return myPage;
	}

	@Override
	public void deleteBatch(String[] ids) {
		for(String id:ids) {
			standardDao.findById(id).setDeltag("1");
		}
	}
}
