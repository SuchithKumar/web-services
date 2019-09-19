package com.yolobyob.getthechick.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name = "dealer_table")
public class Dealer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long dealerId;
	
	@NotNull(message = "Dealer Name cannot be null")
	private String dealerName;
	
	@NotNull(message = "Password cannot be null")
	private String password;
	
	@NotNull(message = "Phone cannot be null")
	private String phone;
	
	@NotNull(message = "Email ID cannot be null")
	@Email(message = "Valid Email Id needed")
	private String emailId;
	
	@JsonManagedReference(value = "dealerAddresses")
	@ManyToMany(mappedBy = "dealer")
	private List<Address> addresses;
	
	@JsonManagedReference(value = "dealerOrders")
	@OneToMany(mappedBy = "dealer")
	private List<Order> orders;

	@JsonManagedReference(value = "dealerItems")
	@OneToMany(mappedBy = "dealer")
	private List<Item> dealerItems;
	
	public Dealer() {
		
	}

	public Dealer(@NotNull(message = "Dealer Name cannot be null") String dealerName,
			@NotNull(message = "Password cannot be null") String password,
			@NotNull(message = "Phone cannot be null") String phone,
			@NotNull(message = "Email ID cannot be null") @Email(message = "Valid Email Id needed") String emailId) {
		super();
		this.dealerName = dealerName;
		this.password = password;
		this.phone = phone;
		this.emailId = emailId;
	}

	public Long getDealerId() {
		return dealerId;
	}

	public void setDealerId(Long dealerId) {
		this.dealerId = dealerId;
	}

	public String getDealerName() {
		return dealerName;
	}

	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
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
	
	public List<Item> getItems() {
		return dealerItems;
	}

	public void setItems(List<Item> items) {
		this.dealerItems = items;
	}

	@Override
	public String toString() {
		return "Dealer [dealerId=" + dealerId + ", dealerName=" + dealerName + ", phone="
				+ phone + ", emailId=" + emailId + "]";
	}

	
}
