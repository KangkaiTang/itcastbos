package com.kk.bos.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.kk.bos.domain.Page;
import com.kk.bos.domain.qp.WorkOrderManage;
import com.kk.bos.service.BaseService;
import com.kk.bos.service.qp.IWorkOrderManageService;
import com.opensymphony.xwork2.ActionContext;

public class WorkOrderManageServiceImpl extends BaseService implements
		IWorkOrderManageService {

	@Override
	public Page pageQuery(Page myPage) {
		return pageQuery(myPage, workOrderManageDao);
	}

	@Override
	public void saveOrUpdate(WorkOrderManage workOrderManage) {
		try{
			workOrderManageDao.saveOrUpdate(workOrderManage);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("result", "success");
			map.put("msg","successfully store the data");
			ActionContext.getContext().put("map", map);
		}catch(Exception e) {
			e.printStackTrace();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("result", "failure");
			map.put("msg","unsuccessfully store the data");
			ActionContext.getContext().put("map", map);
		}
	}

	@Override
	public Page queryByLucene(String conditionName, String conditionValue,
			Page myPage) {
		return workOrderManageDao.queryByLucene(conditionName, conditionValue, myPage);
	}
}
