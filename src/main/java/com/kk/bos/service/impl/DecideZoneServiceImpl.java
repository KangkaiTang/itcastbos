package com.kk.bos.service.impl;

import com.kk.bos.domain.Page;
import com.kk.bos.domain.bc.DecideZone;
import com.kk.bos.domain.bc.Subarea;
import com.kk.bos.service.BaseService;
import com.kk.bos.service.bc.IDecideZone;

public class DecideZoneServiceImpl extends BaseService implements IDecideZone {
	
	@Override
	public Page pageQuery(Page myPage) {
		
		return pageQuery(myPage, decideZoneDao);
	}

	@Override
	public void saveOrUpdate(DecideZone decideZone, String[] subareaIds) {
		// 1.修改subarea 的属性
		for(String subareaId:subareaIds) {
			Subarea subarea = subareaDao.findById(subareaId);
			subarea.setDecideZone(decideZone);
		}
		
		// 2.存入decideZone
		decideZoneDao.saveOrUpdate(decideZone);
	}
}
