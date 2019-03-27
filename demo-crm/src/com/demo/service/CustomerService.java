package com.demo.service;

import com.demo.pojo.Customer;
import com.demo.pojo.QueryVo;
import com.demo.utils.Page;

public interface CustomerService {
	//根据条件分页查询客户
	Page<Customer> queryCustomerByQueryVo(QueryVo queryVo);
	
	//根据id查询数据
	Customer queryCustomerById(Long id);
	
	
	 //根据id编辑客户数据
	void updateCustomerById(Customer customer);
	
	//根据id删除用户
	void deleteCustomerById(Long id);
}
