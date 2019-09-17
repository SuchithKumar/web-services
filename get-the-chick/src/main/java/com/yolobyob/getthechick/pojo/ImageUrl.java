package com.yolobyob.getthechick.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class ImageUrl {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long imageId;
	
	@NotNull(message = "Image url cannot be null")
	private String imageUrl;
	
	@ManyToOne
	private Item item;

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
