package com.hand.exam.api.service;


import com.hand.exam.domain.entity.CustomerE;

public interface CustomerService {

	public  int isExist(CustomerE customerE);

	public  int  insert(CustomerE customerE, String address);


	CustomerE update(CustomerE customerE, String address);

	int   deleteByPrimaryKey(Short id);
}
