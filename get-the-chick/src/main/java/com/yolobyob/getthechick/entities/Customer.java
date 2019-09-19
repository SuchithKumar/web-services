package com.yolobyob.getthechick.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name = "customer_table")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long customerId;
	
	@NotNull(message = "Customer Name cannot be null")
	private  String customerName;
	
	@NotNull(message = "Password cannot be null")
	private String password;
	
	@NotNull(message = "Phone cannot be null")
	private String phone;
	
	@NotNull(message = "Email ID cannot be null")
	@Email(message = "Valid Email Id needed")
	private String emailId;
	
	@JsonManagedReference(value = "customerAddresses")
	@OneToMany(mappedBy = "customer")
	private List<Address> addresses;
	
	@JsonManagedReference(value = "customerOrders")
	@OneToMany(mappedBy = "customer")
	private List<Order> orders;

	public Customer() {
		
	}
	
	public Customer( @NotNull(message = "Customer Name cannot be null") String customerName,
			@NotNull(message = "Password cannot be null") String password,
			@NotNull(message = "Phone cannot be null") String phone,
			@NotNull(message = "Email ID cannot be null") @Email(message = "Valid Email Id needed") String emailId) {
		super();
		this.customerName = customerName;
		this.password = password;
		this.phone = phone;
		this.emailId = emailId;
	}

	public Long getCustomerId() {
		return customerId;
	}


	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}


	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", phone=" + phone + ", emailId=" + emailId + "]";
	}


}
