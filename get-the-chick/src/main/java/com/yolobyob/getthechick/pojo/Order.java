package com.yolobyob.getthechick.pojo;

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

@Entity(name = "order_table")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long orderId;
	
	@NotNull(message = "Order Date cannot be null")
	@PastOrPresent(message = "Order Date cannot be a Future Date")
	private Date orderDate;
	
	@NotNull(message = "Item cannot be null")
	@OneToMany(mappedBy = "order")
	private List<Item> items;
	
	@NotNull(message = "Customer cannot be null")
	@ManyToOne
	private Customer customer;
	
	@NotNull(message = "Dealer cannot be null")
	@ManyToOne
	private Dealer dealer;
	
	public Order() {
		
	}

	public Order(long orderId,
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

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
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

	public Dealer getDealer() {
		return dealer;
	}

	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderDate=" + orderDate + ", items=" + items + ", customer=" + customer
				+ ", dealer=" + dealer + "]";
	}

	
}
