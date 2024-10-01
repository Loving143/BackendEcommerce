package com.smart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.smart.dto.ChangePasswordRequest;
import com.smart.entity.Userss;
import com.smart.service.EmailServices;
import com.smart.service.UserService;
@RestController
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private EmailServices email;	
	public UserController() {
		// TODO Auto-generated constructor stub
	}
	
	@PostMapping("/register")
	public String RegisterUser(@RequestBody Userss user) {
		
		userService.registerUser(user);
		return "User registered successfully.";
	}
	@PreAuthorize(" hasRole('READ') ")
	@GetMapping("/userDetails/{username}")
	public Userss getUserDetails(@PathVariable String username) {
		return (Userss) userService.getUserDetails(username);
	}
	
	@GetMapping("sendemail")
	public String sendMail() {
		email.sendEmail("love143loving@gmail.com", "Test Body","Fucking Prateek");
		return "Email sent";
	}
	
	@PostMapping("/changePassword")
    public String ChangePassword(@RequestBody ChangePasswordRequest request){
    	userService.changePassword(request);
    	return "Password changed successfully";
    }
	
	

}
