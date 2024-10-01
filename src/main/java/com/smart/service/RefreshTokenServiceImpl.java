package com.smart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.entity.RefreshToken;
import com.smart.repository.RefreshTokenRepository;
import com.smart.repository.UserRepository;

@Service
public class RefreshTokenServiceImpl implements RefreshTokenService {
	
	@Autowired
	private RefreshTokenRepository refreshTokenRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public RefreshToken createRefreshToken(String userName ) {
		return null;
	}
	

}
