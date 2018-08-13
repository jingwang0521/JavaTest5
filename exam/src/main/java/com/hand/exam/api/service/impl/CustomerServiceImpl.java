package com.hand.exam.api.service.impl;


import com.hand.exam.api.service.CustomerService;
import com.hand.exam.domain.entity.CustomerE;
import com.hand.exam.infra.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerMapper customerMapper;

	@Override
	public int isExist(CustomerE customerE) {

		int result=0;

		result=customerMapper.isExist(customerE);

		if (result!=0){

			return result;

		}else {

			return 0;
		}
	}

	@Override
	public int  insert(CustomerE customerE,String adress){

		int adressId=0;

		int cId=0;

		try{
			adressId=customerMapper.queryIdByAddress(adress);
		}catch (Exception e){
			System.out.println("不存在该地址");
		}


		System.out.println("地址id"+adressId);

		customerE.setAddressId((short) adressId);

		try {
			int result=customerMapper.insert(customerE);
		}catch (Exception e){
			System.out.println("插入失败");
		}


		cId=customerMapper.returnCustomerId(customerE);
		return  cId;
	}



	@Override
	public CustomerE update(CustomerE customerE, String address) {

		int adressId=0;
		try{
			adressId=customerMapper.queryIdByAddress(address);
			if (adressId==0) {
				throw new Exception();
			}
		}catch (Exception e){

		}
		customerE.setAddressId((short) adressId);

		customerMapper.update(customerE);
		Short id=customerE.getCustomerId();

		CustomerE c=customerMapper.selectByPrimaryKey(id);

		return c;
	}


	@Override
	public int deleteByPrimaryKey(Short id) {
		return customerMapper.deleteByPrimaryKey(id);
	}
}
