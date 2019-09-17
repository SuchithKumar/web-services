package com.yolobyob.getthechick.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity(name = "stock_table")
public class Stock {

	@Id
	private long stockId;
	
	@NotNull(message = "Quantity Cannot be null")
	private long quantity;
	
	@OneToOne(mappedBy = "stock")
	private Item item;

	public Stock() {
		
	}
	
	public Stock(long stockId, @NotNull(message = "Quantity Cannot be null") long quantity,
			@NotNull(message = "Item Cannot be null") Item item) {
		super();
		this.stockId = stockId;
		this.quantity = quantity;
		this.item = item;
	}

	public long getStockId() {
		return stockId;
	}

	public void setStockId(long stockId) {
		this.stockId = stockId;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "Stock [stockId=" + stockId + ", quantity=" + quantity + "]";
	}
	
}
