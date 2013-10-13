package com.kk.bos.service.bc;

import java.util.List;

import com.kk.bos.domain.bc.Region;
import com.kk.bos.service.IPageQuery;

public interface IRegionService extends IPageQuery{

	public void saveOrUpdate(Region region);

	public Object findRegionById(String regionId);

	public List<Region> listAllRegions();

}
