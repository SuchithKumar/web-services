package com.yolobyob.getthechick.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yolobyob.getthechick.dao.CustomerDao;
import com.yolobyob.getthechick.entities.Address;
import com.yolobyob.getthechick.entities.Customer;
import com.yolobyob.getthechick.entities.Order;

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
	
	public Optional<Customer> findCustomerByEmailId(String emailId) {
		return customerDao.findCustomerByEmailId(emailId);
	}
	
	public Customer saveCustomer(Customer customer) {
		return customerDao.saveCustomer(customer);
	}
	
	public Order saveOrder(Order order) {
		return customerDao.saveOrder(order);
	}
	
	public Address saveAddress(Address address) {
		return customerDao.saveAddress(address);
	}
}
