package com.yolobyob.getthechick.dao;

import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yolobyob.getthechick.entities.Customer;
import com.yolobyob.getthechick.jpaRepo.CustomerJpaRepo;
import com.yolobyob.getthechick.util.HibernateUtil;

@Repository
public class CustomerDao {

	HibernateUtil hibernateUtil = new HibernateUtil();
	SessionFactory factory;
	Session session;

	@Autowired
	CustomerJpaRepo customerRepo;

	public Customer saveCustomer(Customer customer) {
		return customerRepo.save(customer);
	}

	public Optional<Customer> getCustomerById(long id) {
		return customerRepo.findById(id);
	}
	
	public Optional<Customer> findCustomerByPhone(String phone){
		Optional<Customer> customer = Optional.empty();
		
		Customer foundCustomer = customerRepo.findByPhone(phone);
		if(foundCustomer!=null) {
			customer = Optional.of(foundCustomer);
		}
		
		return customer;
	}
	
}
