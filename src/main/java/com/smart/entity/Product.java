package com.smart.entity;

import java.io.IOException;
import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.smart.dto.ProductDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String name ;
	
	private Integer price;
	
	private String description;
	
	@OneToMany(mappedBy = "product", cascade= CascadeType.ALL, fetch = FetchType.LAZY)
	private List<CartItems>cartItems;
	
	@Lob
	
	private byte [] img;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="category_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Category category;

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

	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(ProductDto dto) throws IOException {
		this.id = dto.getId();
		this.name = dto.getName();
		this.description = dto.getDescription();
		this.img = dto.getImg().getBytes();
		this.price = dto.getPrice();
	}
	
	public ProductDto getDto() {
		ProductDto dto = new ProductDto();
		dto.setName(name);
		dto.setByteImg(img);
		dto.setCategoryId(id);
		dto.setDescription(description);
		dto.setId(id);
		dto.setDescription(description);
		dto.setPrice(price);
		dto.setCategoryName(category.getName());
		return dto;
	}

	public List<CartItems> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItems> cartItems) {
		this.cartItems = cartItems;
	}
	
	

}
