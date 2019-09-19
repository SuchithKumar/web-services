package com.yolobyob.getthechick.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yolobyob.getthechick.entities.Address;
import com.yolobyob.getthechick.entities.Customer;
import com.yolobyob.getthechick.entities.Order;
import com.yolobyob.getthechick.jpaRepo.AddressJpaRepo;
import com.yolobyob.getthechick.jpaRepo.CustomerJpaRepo;
import com.yolobyob.getthechick.jpaRepo.OrderJpaRepo;

@Repository
public class CustomerDao {

	@Autowired
	CustomerJpaRepo customerRepo;
	
	@Autowired
	AddressJpaRepo addressRepo;
	
	@Autowired
	OrderJpaRepo orderRepo;

	public Customer saveCustomer(Customer customer) {
		return customerRepo.save(customer);
	}

	public Optional<Customer> getCustomerById(long id) {
		return customerRepo.findById(id);
	}

	public Optional<Customer> findCustomerByEmailId(String emailId){
		Optional<Customer> customer = Optional.empty();

		Customer foundCustomer = customerRepo.findByEmailId(emailId);
		if (foundCustomer != null) {
			customer = Optional.of(foundCustomer);
		}

		return customer;
	}
	
	public Optional<Customer> findCustomerByPhone(String phone) {
		Optional<Customer> customer = Optional.empty();

		Customer foundCustomer = customerRepo.findByPhone(phone);
		if (foundCustomer != null) {
			customer = Optional.of(foundCustomer);
		}

		return customer;
	}
	
	

	public Address saveAddress(Address address) {
		return addressRepo.save(address);
	}
	
	public Order saveOrder(Order order) {
		return orderRepo.save(order);
	}
	
}
