package com.kk.bos.service.bc;

import java.util.List;

import com.kk.bos.domain.bc.Subarea;
import com.kk.bos.service.IPageQuery;

public interface ISubareaService extends IPageQuery {

	public void saveOrUpdate(Subarea subarea);

	public List<Subarea> findAllnoDz();

}
