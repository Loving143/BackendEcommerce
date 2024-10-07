package com.smart.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class PasswordResetToken {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;

	    private String token;
	    private LocalDateTime expiryDate;

	    @ManyToOne(fetch = FetchType.EAGER)
	    @JoinColumn(name = "user_id")
	    private Userss user;
	    
	    public PasswordResetToken() {}

	    public PasswordResetToken(String token, Userss user) {
	        this.token = token;
	        this.user = user;
	        this.expiryDate = LocalDateTime.now().plusHours(24); // Token expires in 24 hours
	    }

	    public boolean isExpired() {
	        return LocalDateTime.now().isAfter(this.expiryDate);
	    }

		public String getToken() {
			return token;
		}

		public void setToken(String token) {
			this.token = token;
		}

		public LocalDateTime getExpiryDate() {
			return expiryDate;
		}

		public void setExpiryDate(LocalDateTime expiryDate) {
			this.expiryDate = expiryDate;
		}

		public Userss getUser() {
			return user;
		}

		public void setUser(Userss user) {
			this.user = user;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}
		
		

}
