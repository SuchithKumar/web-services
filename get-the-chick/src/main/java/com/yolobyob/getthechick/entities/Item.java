package com.yolobyob.getthechick.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Complete details of Item/Products of Dealer")
@Entity(name = "item_table")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long itemId;
	
	@NotNull(message = "Item Name Cannot be null")
	@ApiModelProperty(notes = "Name of the Item, Cannot be null")
	private  String itemName;
	
	@NotNull(message = "Item Description Cannot be null")
	@ApiModelProperty(notes = "Description of the Item, Cannot be null")
	private  String description;
	
	@NotNull(message = "Item Price Cannot be null")
	@ApiModelProperty(notes = "Price of the Item, Cannot be null")
	private  Long price;
	
	@NotNull(message = "Stocks Cannot be null")
	@ApiModelProperty(notes = "Quantity of Items, Cannot be null")
	private  Long stocks;
	
	@JsonBackReference(value = "orderItems")
	@ApiModelProperty(notes = "Order of the Item, Cannot be null")
	@ManyToOne(fetch = FetchType.LAZY)
	private Order order;
	
	@JsonManagedReference(value = "itemImageUrls")
	@ApiModelProperty(notes = "All Image Locations of Item, Cannot be null")
	@OneToMany(mappedBy = "item")
	private List<ImageUrl> itemImageUrls;

	@JsonBackReference(value = "dealerItems")
	@ApiModelProperty(notes = "Dealer of the Item, Cannot be null")
	@ManyToOne(fetch = FetchType.LAZY)
	private Dealer dealer;
	
	@ApiModelProperty(notes = "Customer rating of the Item, Cannot be null")
	private  Float rating;
	
	public Item() {
		
	}

	

	public Item(Long itemId, @NotNull(message = "Item Name Cannot be null") String itemName,
			@NotNull(message = "Item Description Cannot be null") String description,
			@NotNull(message = "Item Price Cannot be null") Long price,
			@NotNull(message = "Stocks Cannot be null") Long stocks, Order order, List<ImageUrl> itemImageUrls,
			Dealer dealer, Float rating) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.description = description;
		this.price = price;
		this.stocks = stocks;
		this.order = order;
		this.itemImageUrls = itemImageUrls;
		this.dealer = dealer;
		this.rating = rating;
	}



	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
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

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Long getStocks() {
		return stocks;
	}

	public void setStocks(Long stocks) {
		this.stocks = stocks;
	}


	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<ImageUrl> getItemImageUrls() {
		return itemImageUrls;
	}

	public void setItemImageUrls(List<ImageUrl> itemImageUrls) {
		this.itemImageUrls = itemImageUrls;
	}

	public Dealer getDealer() {
		return dealer;
	}

	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}

	public Float getRating() {
		return rating;
	}

	public void setRating(Float rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", description=" + description + ", price=" + price
				+ "]";
	}

	
}
