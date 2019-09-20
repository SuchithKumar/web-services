package com.yolobyob.getthechick.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "All Details of ImageUrl")
@Entity(name = "imageurl_table")
public class ImageUrl {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long imageId;
	
	@NotNull(message = "Image url cannot be null")
	@ApiModelProperty("URL of the image, Cannot be null")
	private String imageUrl;
	
	@JsonBackReference(value = "itemImageUrls")
	@ManyToOne(fetch = FetchType.LAZY)
	@ApiModelProperty(notes = "Item this Url is linked to, Cannot be null")
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
