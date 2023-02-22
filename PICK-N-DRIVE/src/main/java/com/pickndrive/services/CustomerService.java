package com.pickndrive.services;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.json.JsonMapper.Builder;
import com.pickndrive.daos.CustomerRepository;
import com.pickndrive.entities.Customer;
import com.pickndrive.models.CustomerDTO;

@Service
@Transactional
public class CustomerService {

	@Autowired private CustomerRepository dao;
	
	public Customer registerCustomer(CustomerDTO customerDto) {
		System.out.println("In service method :"+customerDto);
		Customer beforeAdd = new Customer();
	BeanUtils.copyProperties(customerDto, beforeAdd);
	System.out.println("After data upadate :"+beforeAdd);
		//Customer inBetween = 
	Customer added	=dao.save(beforeAdd);
		return added;
	}
	
	public Customer findByUserId(String userid) {
		return dao.getById(userid);
	}

	public List<Customer> allCustomers() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	public Customer validate(String userid, String pwd) {
		Customer cc=dao.getById(userid);
		if(cc!=null && cc.getPwd().equals(pwd)) {
			return cc;
		}
		return null;
	}
	
	public boolean verifyUserId(String userid) {
		// TODO Auto-generated method stub
		return dao.existsById(userid);
	}

	public void updateProfile(CustomerDTO cust) {
		// TODO Auto-generated method stub
		Customer beforeAdd = new Customer();
		BeanUtils.copyProperties(cust, beforeAdd);
		System.out.println("After data upadate :"+beforeAdd);
			//Customer inBetween = 
		
		if(beforeAdd.getPwd().equals("") || beforeAdd.getPwd()==null) {
			beforeAdd.setPwd(dao.getById(beforeAdd.getUserid()).getPwd());
		}
		dao.save(beforeAdd);	
	}

}
