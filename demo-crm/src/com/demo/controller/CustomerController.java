package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.pojo.BaseDict;
import com.demo.pojo.Customer;
import com.demo.pojo.QueryVo;
import com.demo.service.BaseDictService;
import com.demo.service.CustomerService;
import com.demo.utils.Page;

@Controller
@RequestMapping("customer")
public class CustomerController {
	@Autowired
	private BaseDictService baseDictService ;
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("list")
	public String queryCustomerList(Model model,QueryVo queryVo) {
		// 客户来源
		List<BaseDict> fromType = this.baseDictService.queryBaseDictByDictTypeCode("002");
		// 所属行业
		List<BaseDict> industryType = this.baseDictService.queryBaseDictByDictTypeCode("001");
		// 客户级别
		List<BaseDict> levelType = this.baseDictService.queryBaseDictByDictTypeCode("006");

		// 把前端页面需要显示的数据放到模型中
		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType", levelType);
				
		// 分页查询数据
		Page<Customer> page = this.customerService.queryCustomerByQueryVo(queryVo);
		// 把分页查询的结果放到模型中
		model.addAttribute("page", page);

		// 数据回显
		model.addAttribute("custName", queryVo.getCustName());
		model.addAttribute("custSource", queryVo.getCustSource());
		model.addAttribute("custIndustry", queryVo.getCustIndustry());
		model.addAttribute("custLevel", queryVo.getCustLevel());

				
				
		return "customer";

	}
	
	
	//根据id查询用户,返回json格式数据
	@RequestMapping("edit")
	@ResponseBody
	public Customer queryCustomerById(Long id) {
		Customer customer = this.customerService.queryCustomerById(id);
		return customer;
	}
	
	//根据id查询用户,返回更新后客户的json格式数据
	@RequestMapping("update")
	@ResponseBody
	public String updateCustomerById(Customer customer) {
		this.customerService.updateCustomerById(customer);
		return "OK";
	}
	
	//删除用户
	@RequestMapping("delete")
	@ResponseBody
	public String deleteCustomerById(Long id) {
		this.customerService.deleteCustomerById(id);
		return "ok";
	}

}
