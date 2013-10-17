package com.kk.bos.service.qp;

import com.kk.bos.domain.Page;
import com.kk.bos.domain.qp.WorkOrderManage;
import com.kk.bos.service.IPageQuery;

public interface IWorkOrderManageService extends IPageQuery {

	public void saveOrUpdate(WorkOrderManage workOrderManage);

	public Page queryByLucene(String conditionName, String conditionValue,
			Page myPage);

}
