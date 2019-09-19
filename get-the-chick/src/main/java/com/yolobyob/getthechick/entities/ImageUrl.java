package com.yolobyob.getthechick.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity(name = "imageurl_table")
public class ImageUrl {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long imageId;
	
	@NotNull(message = "Image url cannot be null")
	private String imageUrl;
	
	@JsonBackReference(value = "itemImageUrls")
	@ManyToOne(fetch = FetchType.LAZY)
	private Item item;

	public ImageUrl() {
		
	}
	
	public ImageUrl(Long imageId, @NotNull(message = "Image url cannot be null") String imageUrl, Item item) {
		super();
		this.imageId = imageId;
		this.imageUrl = imageUrl;
		this.item = item;
	}

	public long getImageId() {
		return imageId;
	}

	public void setImageId(long imageId) {
		this.imageId = imageId;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "ImageUrl [imageId=" + imageId + ", imageUrl=" + imageUrl + "]";
	}
	
	
}
