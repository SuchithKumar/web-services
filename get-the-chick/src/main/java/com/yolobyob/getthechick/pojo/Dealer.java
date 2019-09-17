package com.yolobyob.getthechick.pojo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity(name = "dealer_table")
public class Dealer {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long dealerId;
	
	@NotNull(message = "Dealer Name cannot be null")
	private String dealerName;
	
	@NotNull(message = "Password cannot be null")
	private String password;
	
	@NotNull(message = "Phone cannot be null")
	private String phone;
	
	@NotNull(message = "Email ID cannot be null")
	private String emailId;
	
	@ManyToMany(mappedBy = "dealer")
	private List<Address> addresses;
	
	@OneToMany(mappedBy = "dealer")
	private List<Order> orders;

	public Dealer() {
		
	}

	public Dealer(long dealerId, @NotNull(message = "Dealer Name cannot be null") String dealerName,
			@NotNull(message = "Password cannot be null") String password,
			@NotNull(message = "Phone cannot be null") String phone,
			@NotNull(message = "Email ID cannot be null") String emailId, List<Address> addresses, List<Order> orders) {
		super();
		this.dealerId = dealerId;
		this.dealerName = dealerName;
		this.password = password;
		this.phone = phone;
		this.emailId = emailId;
		this.addresses = addresses;
		this.orders = orders;
	}

	public long getDealerId() {
		return dealerId;
	}

	public void setDealerId(long dealerId) {
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

	@Override
	public String toString() {
		return "Dealer [dealerId=" + dealerId + ", dealerName=" + dealerName + ", password=" + password + ", phone="
				+ phone + ", emailId=" + emailId + ", addresses=" + addresses + ", orders=" + orders + "]";
	}
	
	
	
}
