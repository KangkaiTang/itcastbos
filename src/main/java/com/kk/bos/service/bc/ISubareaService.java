package com.kk.bos.service.bc;

import com.kk.bos.domain.bc.Subarea;
import com.kk.bos.service.IPageQuery;

public interface ISubareaService extends IPageQuery {

	public void saveOrUpdate(Subarea subarea);

}
