package com.yolobyob.getthechick.controller;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.yolobyob.getthechick.beans.LoginBean;
import com.yolobyob.getthechick.beans.RegisterBean;
import com.yolobyob.getthechick.entities.Customer;
import com.yolobyob.getthechick.entities.Dealer;
import com.yolobyob.getthechick.exception.InvalidUserException;
import com.yolobyob.getthechick.exception.UserCreationException;
import com.yolobyob.getthechick.service.CustomerService;
import com.yolobyob.getthechick.service.DealerService;

@RestController
public class LoginController {

	public static String hostUrl = "http://localhost:4300";

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
			Optional<Customer> customerPhone = customerService.findCustomerByPhone(login.getUserId());
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
			Optional<Dealer> dealerPhone = dealerService.findDealerByPhone(login.getUserId());
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

	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@Valid @RequestBody RegisterBean registerBean) {
		Optional<Customer> customerEmail = customerService.findCustomerByEmailId(registerBean.getEmailId());
		Optional<Customer> customerPhone = customerService.findCustomerByPhone(registerBean.getPhone());
		Optional<Dealer> dealerEmail = dealerService.findDealerByEmailId(registerBean.getEmailId());
		Optional<Dealer> dealerPhone = dealerService.findDealerByPhone(registerBean.getPhone());

		if (customerEmail.isPresent()) {
			throw new UserCreationException("Customer already exists with this Email ID!");
		} else if (customerPhone.isPresent()) {
			throw new UserCreationException("Customer already exists with this Phone Number!");
		} else if (dealerEmail.isPresent()) {
			throw new UserCreationException("Dealer already exists with this Email ID!");
		} else if (dealerPhone.isPresent()) {
			throw new UserCreationException("Dealer already exists with this Phone Number!");
		} else {

			switch (registerBean.getUserType()) {
			case CUSTOMER: {
				Customer customer = new Customer(registerBean.getUserName(), registerBean.getPassword(),
						registerBean.getPhone(), registerBean.getEmailId());
				Customer savedCustomer = customerService.saveCustomer(customer);
				URI uri = ServletUriComponentsBuilder.fromHttpUrl(LoginController.hostUrl + "/customers")
						.path("/{customerId}").build(savedCustomer.getCustomerId());
				return ResponseEntity.created(uri).build();

			}
			case DEALER: {
				Dealer dealer = new Dealer(registerBean.getUserName(), registerBean.getPassword(),
						registerBean.getPhone(), registerBean.getEmailId());

				Dealer savedDealer = dealerService.saveDealer(dealer);
				URI uri = ServletUriComponentsBuilder.fromHttpUrl(LoginController.hostUrl + "/dealers")
						.path("/{dealerId}").build(savedDealer.getDealerId());
				return ResponseEntity.created(uri).build();

			}
			case ADMIN: {

				break;
			}
			default:
				break;
			}

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
}
