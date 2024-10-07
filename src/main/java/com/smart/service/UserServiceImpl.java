package com.smart.service;

import java.util.Optional;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.smart.dto.ChangePasswordRequest;
import com.smart.entity.Orders;
import com.smart.entity.Userss;
import com.smart.enumm.OrderStatus;
import com.smart.repository.OrderRepository;
import com.smart.repository.UserRepository;
import com.smart.request.RegisterRequest;

@Service
public class UserServiceImpl implements UserService{
	
	    @Autowired
	    private UserRepository userRepository;

	    @Autowired
	    private PasswordEncoder passwordEncoder;
	    
	    @Autowired
	    private OrderRepository orderRepository;


		// Find user by username
	    public Optional<Userss> findByUsername(String username) {
	        return userRepository.findByUsername(username);
	    
	}


	@Override
	public void registerUser(RegisterRequest user) throws Exception {
		 if(userRepository.existsByUsername(user.getUsername())) {
			 throw new BadRequestException("User with username already exists.");
		 }
		 Userss userr = new Userss(user);
		 userr.setPassword(passwordEncoder.encode(user.getPassword()));
	       Userss users =  userRepository.save(userr);
	     Orders order = new Orders();
	     order.setAmount(0);
	     order.setTotalAmount(0);
	     order.setDiscount(0);
	     order.setUser(users);
	     order.setOrderStatus(OrderStatus.PENDING);
	     orderRepository.save(order);
	     
	}


	public UserServiceImpl() {
		super();
	}


	@Override
	public Userss getUserDetails(String username) {
		return userRepository.findByUsername(username)
				.orElseThrow(()->new RuntimeException("User not found"));
	}


	@Override
	public void changePassword(ChangePasswordRequest request) {
		System.out.println(SecurityContextHolder.getContext().getAuthentication().getName()+"This is the user");
		Userss user = userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName())
				.orElseThrow(()->new RuntimeException("User not found"));
		
		if(passwordEncoder.matches(request.getCurrentPassword(), user.getPassword())) {
			if(!request.getNewPassword().equals(request.getConfirmPassword()))
				throw new RuntimeException("New Password and Confirm password did not matched!");
			user.setPassword(passwordEncoder.encode( request.getNewPassword()));
			userRepository.save(user);
		}
		else {
			throw new RuntimeException("Current Password is not valid!");
		}
		
	}

}
