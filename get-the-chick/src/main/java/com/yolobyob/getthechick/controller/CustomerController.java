package com.yolobyob.getthechick.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.yolobyob.getthechick.entities.Customer;
import com.yolobyob.getthechick.exception.DealerNotFoundException;
import com.yolobyob.getthechick.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService customerService;

	@GetMapping("/customers/{customerId}")
	public Customer getCustomerById(@PathVariable long customerId) {

		Optional<Customer> customer = customerService.getCustomerById(customerId);
		if (customer.isPresent()) {
			return customer.get();
		} else {
			throw new DealerNotFoundException("Customer with ID-" + customerId + " was not found in our DB!");
		}
	}
	
}
