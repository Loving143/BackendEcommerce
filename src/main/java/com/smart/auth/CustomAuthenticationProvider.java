package com.smart.auth;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.smart.entity.Userss;
import com.smart.repository.UserRepository;
import com.smart.service.UserService;

	
	public class CustomAuthenticationProvider implements AuthenticationProvider {

   
	private static final Logger logger = LoggerFactory.getLogger(CustomAuthenticationProvider.class);
    @Autowired
    private UserRepository userRepo;
    
    @Autowired
    private UserService userService;
    

    @Autowired
    private CustomUserDetailsService userDetailsService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

	@Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
			logger.info("Executing custom authnetication provider");
	        String username = authentication.getName();
	        String password = authentication.getCredentials().toString();
	        List<GrantedAuthority> authorities =(List<GrantedAuthority>) authentication.getAuthorities();
	        System.out.println(authorities+"This is the auth");
//	        Userss users = userService.findByUsername(username)
//	                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
	        UserDetails user = userDetailsService.loadUserByUsername(username);
	        System.out.println(user.getPassword()+" yu "+ password);
	        if (passwordEncoder.matches(password, user.getPassword())) {
	            return new UsernamePasswordAuthenticationToken(username, password,authorities);
	        }
	        else {
	        	throw new RuntimeException("Credentials are invalid.");
	        }
	        
	    }

	    @Override
	    public boolean supports(Class<?> authentication) {
	        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	    }


	
	

}