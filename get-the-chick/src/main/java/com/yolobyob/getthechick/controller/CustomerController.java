package com.yolobyob.getthechick.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yolobyob.getthechick.entities.Customer;
import com.yolobyob.getthechick.entities.Dealer;
import com.yolobyob.getthechick.entities.Order;
import com.yolobyob.getthechick.exception.DealerNotFoundException;
import com.yolobyob.getthechick.exception.OrderNotFoundException;
import com.yolobyob.getthechick.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@GetMapping("/customers/{customerId}")
	public Customer getCustomerById(@PathVariable Long customerId) {

		Optional<Customer> customer = customerService.getCustomerById(customerId);
		if (customer.isPresent()) {
			return customer.get();
		} else {
			throw new DealerNotFoundException("Customer with ID-" + customerId + " was not found in our DB!");
		}
	}

	@PostMapping("/customers/{customerId}/orders")
	public Order saveOrder(@Valid @RequestBody Order order, @PathVariable Long customerId) {
		Dealer dealer = order.getItems().get(0).getDealer();
		Customer customer = getCustomerById(customerId);

		order.setDealer(dealer);
		order.setCustomer(customer);

		return customerService.saveOrder(order);
	}

	@GetMapping("/customers/{customerId}/orders")
	public List<Order> getCustomerOrders(@PathVariable Long customerId) {
		Customer customer = getCustomerById(customerId);
		return customer.getOrders();
	}

	@GetMapping("/customers/{customerId}/orders/{orderId}")
	public Order getCustomerOrderById(@PathVariable Long customerId, @PathVariable Long orderId) {
		Customer customer = getCustomerById(customerId);
		List<Order> orders = customer.getOrders();
		Iterator<Order> iterator = orders.iterator();
		Order order = null;
		while (iterator.hasNext()) {
			order = iterator.next();
			if (order.getOrderId() == orderId) {
				break;
			}
		}
		throw new OrderNotFoundException("");

	}

}
