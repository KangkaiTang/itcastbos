package com.kk.bos.service.impl;

import java.sql.Timestamp;

import com.kk.bos.domain.bc.DecideZone;
import com.kk.bos.domain.qp.NoticeBill;
import com.kk.bos.domain.qp.WorkBill;
import com.kk.bos.service.BaseService;
import com.kk.bos.service.qp.INoticeBillService;

public class NoticeBillServiceImpl extends BaseService implements
		INoticeBillService {

	@Override
	public void save(NoticeBill noticeBill) {
		noticeBillDao.save(noticeBill);
		System.out.println(noticeBill.getPickaddress());
		// 1.通过地址找decideZoneId
		String decidedZoneId = customerService
				.findDecidedZoneIdByCustomerAddress(noticeBill.getPickaddress());
		if(decidedZoneId !=null) {
			//2 能找到定区，自动分配
			DecideZone decideZone = decideZoneDao.findById(decidedZoneId);
						
			noticeBill.setOrdertype(NoticeBill.ORDERAUTO);
			noticeBill.setStaff(decideZone.getStaff());
			//2.1 存入workBill
			WorkBill workBill = new WorkBill();
			workBill.setNoticeBill(noticeBill);
			workBill.setStaff(noticeBill.getStaff());
			workBill.setType(WorkBill.TYPENEW);
			workBill.setPickstate(WorkBill.STATENEW);
			workBill.setBuildtime(new Timestamp(System.currentTimeMillis()));
			workBill.setAttachbilltimes(0);
			workBill.setRemark(noticeBill.getRemark());
			
			workBillDao.save(workBill);
		} else{
			//3.手动分配
			noticeBill.setOrdertype(NoticeBill.ORDERMAN);
		}

	}

}
