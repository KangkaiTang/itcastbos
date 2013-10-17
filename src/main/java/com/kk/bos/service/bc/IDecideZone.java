package com.kk.bos.service.bc;

import com.kk.bos.domain.bc.DecideZone;
import com.kk.bos.service.IPageQuery;

public interface IDecideZone extends IPageQuery {

	public void saveOrUpdate(DecideZone decideZone, String[] subareaId);

}
