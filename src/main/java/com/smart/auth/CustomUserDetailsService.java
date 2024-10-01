package com.smart.auth;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.smart.entity.Userss;
import com.smart.repository.UserRepository;
@Service
public class CustomUserDetailsService implements UserDetailsService{

	    @Autowired
	    private UserRepository userRepository;

	    @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        Optional<Userss> user = userRepository.findByUsername(username);
	        if (user.isEmpty()) {
	            throw new RuntimeException("User not found with username: " + username);
	        }

	        // Return a UserDetails object that Spring Security uses to authenticate and authorize
//	        return new org.springframework.security.core.userdetails.User(
//	                user.get().getUsername(), user.get().getPassword(), getAuthorities(user.get()));
	        return new CustomUserDetails(user.get());
	    }

	    private Collection<? extends GrantedAuthority> getAuthorities(Userss user) {
	        return user.getRoles().stream()
	                .map(role -> new SimpleGrantedAuthority(role.getName()))
	                .collect(Collectors.toList());
	    }
	}
