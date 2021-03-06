package com.kk.bos.service.impl;

import java.util.List;

import com.kk.bos.dao.IGenericDao;
import com.kk.bos.domain.Page;
import com.kk.bos.domain.bc.Subarea;
import com.kk.bos.service.BaseService;
import com.kk.bos.service.bc.ISubareaService;

public class SubareaServiceImpl extends BaseService implements ISubareaService {

	@Override
	public Page pageQuery(Page myPage) {
		return pageQuery(myPage, subareaDao);
	}

	@Override
	public void saveOrUpdate(Subarea subarea) {
		subareaDao.saveOrUpdate(subarea);
	}

	@Override
	public List<Subarea> findAllnoDz() {
		// TODO Auto-generated method stub
		return subareaDao.findByNamedQuery("Subarea.listnodz");
	}

}
