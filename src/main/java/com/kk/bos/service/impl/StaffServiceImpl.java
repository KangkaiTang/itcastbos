package com.kk.bos.service.impl;

import com.kk.bos.domain.Page;
import com.kk.bos.domain.bc.Staff;
import com.kk.bos.service.BaseService;
import com.kk.bos.service.bc.IStaffService;

public class StaffServiceImpl extends BaseService implements IStaffService {

	@Override
	public void saveOrUpdate(Staff staff) {
		staffDao.saveOrUpdate(staff);
	}

	@Override
	public Page pageQuery(Page myPage) {
		return pageQuery(myPage, staffDao);
	}

	@Override
	public void changeStatusBatch(String[] staffIds, String status) {
		for(String staffId : staffIds) {
			staffDao.findById(staffId).setDeltag(status);
		}
	}
}
