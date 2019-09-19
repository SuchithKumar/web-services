package com.yolobyob.getthechick.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity(name = "address_table")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long addressId;
	
	@NotNull(message = "House number/Building name cannot be null")
	private String houseNoOrBuildingName;
	
	@NotNull(message = "Road/Area/Colony cannot be null")
	private String roadOrAreaOrColony;
	
	private String addressLine2;
	
	@NotNull
	@Size(max = 6,min = 6 , message = "Zip code should be a 6 digit number")
	private String zipCode;
	
	@NotNull(message = "City cannot be null")
	private String city;
	
	@NotNull(message = "State cannot be null")
	private String state;
	
	@NotNull(message = "landmark cannot be null")
	private String landmark;
	
	@JsonBackReference(value = "customerAddresses")
	@ManyToOne(fetch = FetchType.LAZY)
	private Customer customer;
	
	@JsonBackReference(value = "dealerAddresses")
	@ManyToOne(fetch = FetchType.LAZY)
	private Dealer dealer;

	

	public Address(Long addressId,
			@NotNull(message = "House number/Building name cannot be null") String houseNoOrBuildingName,
			@NotNull(message = "Road/Area/Colony cannot be null") String roadOrAreaOrColony, String addressLine2,
			@NotNull @Size(max = 6, min = 6, message = "Zip code should be a 6 digit number") String zipCode,
			@NotNull(message = "City cannot be null") String city,
			@NotNull(message = "State cannot be null") String state,
			@NotNull(message = "landmark cannot be null") String landmark, Customer customer, Dealer dealer) {
		super();
		this.addressId = addressId;
		this.houseNoOrBuildingName = houseNoOrBuildingName;
		this.roadOrAreaOrColony = roadOrAreaOrColony;
		this.addressLine2 = addressLine2;
		this.zipCode = zipCode;
		this.city = city;
		this.state = state;
		this.landmark = landmark;
		this.customer = customer;
		this.dealer = dealer;
	}

	public Address() {
		
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public String getHouseNoOrBuildingName() {
		return houseNoOrBuildingName;
	}

	public void setHouseNoOrBuildingName(String houseNoOrBuildingName) {
		this.houseNoOrBuildingName = houseNoOrBuildingName;
	}

	public String getRoadOrAreaOrColony() {
		return roadOrAreaOrColony;
	}

	public void setRoadOrAreaOrColony(String roadOrAreaOrColony) {
		this.roadOrAreaOrColony = roadOrAreaOrColony;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Dealer getDealer() {
		return dealer;
	}

	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", houseNoOrBuildingName=" + houseNoOrBuildingName
				+ ", roadOrAreaOrColony=" + roadOrAreaOrColony + ", addressLine2=" + addressLine2 + ", zipCode="
				+ zipCode + ", city=" + city + ", state=" + state + ", landmark=" + landmark + "]";
	}

	
}
