package com.yolobyob.getthechick.pojo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity(name = "item_table")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long itemId;
	
	@NotNull(message = "Item Name Cannot be null")
	private String itemName;
	
	@NotNull(message = "Item Description Cannot be null")
	private String description;
	
	@NotNull(message = "Item Price Cannot be null")
	private long price;
	
	@OneToOne
	private Stock stock;
	
	@ManyToOne
	private Order order;
	
	@OneToMany(mappedBy = "item")
	private List<ImageUrl> itemImageUrls;
	
	private float rating;
	
	public Item() {
		
	}

	public Item(long itemId, @NotNull(message = "Item Name Cannot be null") String itemName,
			@NotNull(message = "Item Description Cannot be null") String description,
			@NotNull(message = "Item Price Cannot be null") long price, Stock stock, Order order,
			List<ImageUrl> itemImageUrls, float rating) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.order = order;
		this.itemImageUrls = itemImageUrls;
		this.rating = rating;
	}

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}



	public List<ImageUrl> getItemImageUrls() {
		return itemImageUrls;
	}

	public void setItemImageUrls(List<ImageUrl> itemImageUrls) {
		this.itemImageUrls = itemImageUrls;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}



	public Order getOrder() {
		return order;
	}



	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", description=" + description + ", price=" + price
				+ ", stock=" + stock + ", order=" + order + ", itemImageUrls=" + itemImageUrls + ", rating=" + rating
				+ "]";
	}

	
}
