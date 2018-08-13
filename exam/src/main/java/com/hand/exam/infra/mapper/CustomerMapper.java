package com.hand.exam.infra.mapper;


import com.hand.exam.domain.entity.CustomerE;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerMapper {
	public  int isExist(CustomerE customerE);


	public int  queryIdByAddress(String address);


	public  int insert(CustomerE customerE);

	public  int returnCustomerId(CustomerE customerE);

	public int  update(CustomerE customerE);

	public CustomerE selectByPrimaryKey(short id);


	int deleteByPrimaryKey(Short id);
}
