package com.kk.bos.service.bc;

import java.util.List;

import com.kk.bos.domain.Page;
import com.kk.bos.domain.bc.Standard;
import com.kk.bos.service.IPageQuery;

public interface IStandardService extends IPageQuery{

	public void saveOrUpdate(Standard standard);

	public void deleteBatch(String[] ids);

	public List listAll();

}
