package com.kk.bos.service.impl;

import java.util.List;

import com.kk.bos.domain.Page;
import com.kk.bos.domain.bc.Region;
import com.kk.bos.service.BaseService;
import com.kk.bos.service.bc.IRegionService;

public class RegionServiceImpl extends BaseService implements IRegionService {

	@Override
	public void saveOrUpdate(Region region) {
		// TODO Auto-generated method stub
		regionDao.saveOrUpdate(region);	
	}

	@Override
	public Object findRegionById(String regionId) {
		return regionDao.findById(regionId);
	}

	@Override
	public Page pageQuery(Page myPage) {
		return pageQuery(myPage, regionDao);
	}

	@Override
	public List<Region> listAllRegions() {
		return regionDao.listAll();
	}
}
