package com.yolobyob.getthechick.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yolobyob.getthechick.dao.CustomerDao;
import com.yolobyob.getthechick.entities.Customer;

@Service
public class CustomerService {

	@Autowired
	CustomerDao customerDao;
	
	public Optional<Customer> getCustomerById(long id){
		return customerDao.getCustomerById(id);
	}
	
	public Optional<Customer> findCustomerByPhone(String phone) {
		return customerDao.findCustomerByPhone(phone);
	}
	
	public Customer saveCustomer(Customer customer) {
		return customerDao.saveCustomer(customer);
	}
	
}
