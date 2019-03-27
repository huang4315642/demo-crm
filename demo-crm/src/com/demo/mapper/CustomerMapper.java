package com.demo.mapper;

import java.util.List;

import com.demo.pojo.Customer;
import com.demo.pojo.QueryVo;

public interface CustomerMapper {

	//根据queryVo分页查询数据
	List<Customer> queryCustomerByQueryVo(QueryVo queryVo);
	
	//根据queryVo查询数据条数
	int queryCountByQueryVo(QueryVo queryVo);
	
	//根据id查询客户
	Customer queryCustomerById(Long id);
	
	//根据id编辑客户
	void updateCustomerById(Customer customer);
	
	//根据id删除用户
	void deleteCustomerById(Long id);
	
}
