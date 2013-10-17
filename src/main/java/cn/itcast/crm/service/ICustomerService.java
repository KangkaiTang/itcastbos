package cn.itcast.crm.service;

import java.util.List;

import cn.itcast.crm.domain.Customer;

public interface ICustomerService {
	
	public List<Customer> listUnascCustomer();
	public List<Customer> listHsascCustomer(String decideZoneId);
	public void associate(String[] custoemrIds, String decideZoneId);
	public String findDecidedZoneIdByCustomerAddress(String address);
}
