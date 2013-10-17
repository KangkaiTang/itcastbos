package com.kk.bos.crm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.crm.service.ICustomerService;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class CustomerServiceTest {

	@Autowired
	private ICustomerService cservice;
	
	@Test
	public void test1(){
		System.out.println(cservice.listUnascCustomer());
	}
	
	@Test
	public void test2() {
		
		cservice.associate(new String[]{"2","3"}, "DZ003");
	}
	
	@Test
	public void test3() {
		System.out.println(cservice.findDecidedZoneIdByCustomerAddress("浙江省温州市黎明西路01"));
	}
}
