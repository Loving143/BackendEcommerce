package com.smart.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;




@Entity
public class Otp {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String username;
	    private String otpCode;

	    @Column(name = "expiry_time")
	    private LocalDateTime expiryTime;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getOtpCode() {
			return otpCode;
		}

		public void setOtpCode(String otpCode) {
			this.otpCode = otpCode;
		}

		public LocalDateTime getExpiryTime() {
			return expiryTime;
		}

		public void setExpiryTime(LocalDateTime expiryTime) {
			this.expiryTime = expiryTime;
		}
	    
	    
	}

