package com.kk.bos.service.bc;

import com.kk.bos.domain.Page;
import com.kk.bos.domain.bc.Standard;

public interface IStandardService {

	public void saveOrUpdate(Standard standard);

	public Page pageQuery(Page myPage);

	public void deleteBatch(String[] ids);


}
