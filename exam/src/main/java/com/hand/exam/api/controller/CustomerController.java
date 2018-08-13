package com.hand.exam.api.controller;

import com.hand.exam.api.service.CustomerService;
import com.hand.exam.domain.entity.CustomerE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;


	//登录接口
	@PostMapping(value = "/login")
	public String login(@RequestBody HashMap<String,Object> map ){

		CustomerE customerE=new CustomerE();
		customerE.setFirstName((String) map.get("name"));
		customerE.setLastName((String) map.get("password"));
		int re=customerService.isExist(customerE);
		if (re!=0){
			System.out.println("登录成功");
		}
		return "登录成功";
	}



	//新增用户
	@PutMapping(value = "/add")
	public int  addCustomer(@RequestBody HashMap<String,Object> map ) {


		CustomerE customerE=new CustomerE();
		customerE.setFirstName((String) map.get("firstName"));
		customerE.setLastName((String) map.get("lastName"));
		customerE.setEmail((String) map.get("email"));


		int customerId=0;
		try {
			customerId=customerService.insert(customerE,(String) map.get("address"));
			return customerId;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("插入失败");
		}
		return customerId;
	}


	//更新用户
	@PutMapping(value = "/update")
	public CustomerE  updateCustomer(@RequestBody HashMap<String,Object> map) {

		CustomerE customerE=new CustomerE();
		customerE.setFirstName((String) map.get("firstName"));
		customerE.setLastName((String) map.get("lastName"));
		customerE.setEmail((String) map.get("email"));
		customerE.setCustomerId(Short.valueOf(String.valueOf(map.get("customerId"))));



		CustomerE customerUpdate=new CustomerE();
		try {
			customerUpdate=customerService.update(customerE,(String) map.get("address"));
			return customerUpdate;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("插入失败");
		}
		return customerUpdate;
	}



	//删除用户
	@DeleteMapping(value = "/{id}")
	public String  deleteCustomer(@PathVariable Short id) {
		int re=0;
		re=customerService.deleteByPrimaryKey(id);

		if (re==1){
			return "success";
		}else {
			return "failed";
		}
	}


}
