package com.smart.auth;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import com.smart.service.OtpService;

public class OtpAuthenticationProvider implements AuthenticationProvider{
	
	private static final Logger logger = LoggerFactory.getLogger(OtpAuthenticationProvider.class);
	
	    @Autowired
	    private OtpService otpService;

	    @Override
	    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
	    	logger.info("Otp provider executed");;
	        String username = authentication.getName();
	        String otpCode = authentication.getCredentials().toString();

	        if (otpService.validateOtp(username, otpCode)) {
	            return new UsernamePasswordAuthenticationToken(authentication.getPrincipal(), authentication.getCredentials(),new ArrayList<>());
	        } else {
	            throw new BadCredentialsException("Invalid OTP");
	        }
	    }

	    @Override
	    public boolean supports(Class<?> authentication) {
	        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	    }

		
	}

