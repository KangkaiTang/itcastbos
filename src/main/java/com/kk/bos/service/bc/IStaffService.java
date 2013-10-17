package com.kk.bos.service.bc;

import java.util.List;

import com.kk.bos.domain.Page;
import com.kk.bos.domain.bc.Staff;

public interface IStaffService {

	public void saveOrUpdate(Staff staff);

	public Page pageQuery(Page myPage);

	public void changeStatusBatch(String[] staffIds, String status);

	public List<Staff> findAllStaffs();

}
