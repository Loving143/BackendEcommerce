package com.smart.dto;

import org.springframework.web.multipart.MultipartFile;

public class ProductDto {
	
	private Integer id;
	private String name ;
	private Integer price ;
	private String description;
	private byte[] byteImg;
	private Integer categoryId;
	private String categoryName;
	private MultipartFile img;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public byte[] getByteImg() {
		return byteImg;
	}
	public void setByteImg(byte[] byteImg) {
		this.byteImg = byteImg;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public MultipartFile getImg() {
		return img;
	}
	public void setImg(MultipartFile img) {
		this.img = img;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	} 
	
	
	
	

}
