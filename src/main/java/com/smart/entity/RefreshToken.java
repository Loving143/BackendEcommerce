package com.smart.entity;

import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class RefreshToken {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String token;
	private Instant expiryDate;
	@OneToOne
	@JoinColumn(name ="user_id", referencedColumnName="id")
	private Userss userInfo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Instant getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Instant expiryDate) {
		this.expiryDate = expiryDate;
	}
	public Userss getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(Userss userInfo) {
		this.userInfo = userInfo;
	}
	public RefreshToken() {
		super();
		// TODO Auto-generated constructor stub
	}

}
