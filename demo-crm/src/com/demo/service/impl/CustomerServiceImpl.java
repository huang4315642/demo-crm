package com.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mapper.CustomerMapper;
import com.demo.pojo.Customer;
import com.demo.pojo.QueryVo;
import com.demo.service.CustomerService;
import com.demo.utils.Page;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerMapper customerMapper;

	
	public Page<Customer> queryCustomerByQueryVo(QueryVo queryVo) {
		// TODO Auto-generated method stub
		
		// 设置查询条件,从哪一条数据开始查
			queryVo.setStart((queryVo.getPage() - 1) * queryVo.getRows());

		// 查询数据结果集
			List<Customer> list = this.customerMapper.queryCustomerByQueryVo(queryVo);
		// 查询到的数据总条数
			int total = this.customerMapper.queryCountByQueryVo(queryVo);

		// 封装返回的page对象
			Page<Customer> page = new Page(total, queryVo.getPage(), queryVo.getRows(), list);

		
		return page;
	}

	
	public Customer queryCustomerById(Long id) {
		Customer customer = this.customerMapper.queryCustomerById(id);
		return customer;
	}
	
	
	public void updateCustomerById(Customer customer) {
		this.customerMapper.updateCustomerById(customer);
	}
	
	
	public void deleteCustomerById(Long id) {
		this.customerMapper.deleteCustomerById(id);
	}


}
