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
	public void deleteBatch(String[] ids) {
		for(String id:ids) {
			standardDao.findById(id).setDeltag("1");
		}
	}

	@Override
	public List listAll() {
		return standardDao.findByNamedQuery("listAll");
	}


	@Override
	public Page pageQuery(Page myPage) {
		// TODO Auto-generated method stub
		return pageQuery(myPage, standardDao);
	}
}
