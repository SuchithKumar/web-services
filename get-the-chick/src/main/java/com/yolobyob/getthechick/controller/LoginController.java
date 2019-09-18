package com.yolobyob.getthechick.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yolobyob.getthechick.exception.InvalidUserException;
import com.yolobyob.getthechick.pojo.Customer;
import com.yolobyob.getthechick.pojo.Dealer;
import com.yolobyob.getthechick.pojo.LoginBean;
import com.yolobyob.getthechick.service.CustomerService;
import com.yolobyob.getthechick.service.DealerService;

@RestController
public class LoginController {

	@Autowired
	DealerService dealerService;

	@Autowired
	CustomerService customerService;

	@PostMapping("/login")
	public ResponseEntity<String> validateUser(@Valid @RequestBody LoginBean login) {
		boolean validUser = false;
		switch (login.getUserType()) {
		case CUSTOMER: {
			Optional<Customer> customerId = customerService.getCustomerById(Long.parseLong(login.getUserId()));
			Optional<Customer> customerPhone = customerService.getCustomerByPhone(login.getUserId());
			if (customerId.isPresent()) {
				if (customerId.get().getPassword().equals(login.getPassword())) {
					validUser = true;
				}
			} else if (customerPhone.isPresent()) {
				if (customerPhone.get().getPassword().equals(login.getPassword())) {
					validUser = true;
				}
			}
			break;
		}
		case ADMIN: {

			break;
		}
		case DEALER: {
			Optional<Dealer> dealerId = dealerService.getDealerById(Long.parseLong(login.getUserId()));
			Optional<Dealer> dealerPhone = dealerService.getDealerByPhone(login.getUserId());
			if (dealerId.isPresent()) {
				if (dealerId.get().getPassword().equals(login.getPassword())) {
					validUser = true;
				}
			} else if (dealerPhone.isPresent()) {
				if (dealerPhone.get().getPassword().equals(login.getPassword())) {
					validUser = true;
				}
			}

			break;
		}
		default: {

			break;

		}
		}

		if (validUser == true) {
			return ResponseEntity.ok("Login Successful!");
		} else {
			throw new InvalidUserException("Invalid User ID/Password!");
		}

	}

}
