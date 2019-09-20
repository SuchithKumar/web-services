package com.yolobyob.getthechick.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.swagger.annotations.ApiModelProperty;

@Entity(name = "order_table")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;
	
	@NotNull(message = "Order Date cannot be null")
	@PastOrPresent(message = "Order Date cannot be a Future Date")
	@ApiModelProperty(notes = "Date of the Order, Cannot be null")
	private Date orderDate;
	
	@NotNull(message = "Items cannot be null")
	@ApiModelProperty(notes = "All Items of the Order, Cannot be null")
	@JsonManagedReference(value = "orderItems")
	@OneToMany(mappedBy = "order")
	private List<Item> items;
	
	@JsonBackReference(value = "customerOrders")
	@ApiModelProperty(notes = "Customer who has Ordered, Cannot be null")
	@ManyToOne(fetch = FetchType.LAZY)
	private Customer customer;
	
	@JsonBackReference(value = "dealerOrders")
	@ApiModelProperty(notes = "Dealer of the Order, Cannot be null")
	@ManyToOne(fetch = FetchType.LAZY)
	private Dealer dealer;
	
	public Order() {
		
	}

	public Order(Long orderId,
			@NotNull(message = "Order Date cannot be null") @PastOrPresent(message = "Order Date cannot be a Future Date") Date orderDate,
			@NotNull(message = "Item cannot be null") List<Item> items,
			@NotNull(message = "Customer cannot be null") Customer customer,
			@NotNull(message = "Dealer cannot be null") Dealer dealer) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.items = items;
		this.customer = customer;
		this.dealer = dealer;
	}

	public Long getOrderId() {
		return orderId;
	}



	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}



	public Date getOrderDate() {
		return orderDate;
	}



	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}



	public List<Item> getItems() {
		return items;
	}



	public void setItems(List<Item> items) {
		this.items = items;
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
		return "Order [orderId=" + orderId + ", orderDate=" + orderDate + ", items=" + items + "]";
	}


}
