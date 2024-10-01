package com.smart.controller;

	import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smart.auth.JwtUtil;
import com.smart.auth.LoginResponse;
import com.smart.auth.OtpRequest;
import com.smart.entity.Otp;
import com.smart.entity.Userss;
import com.smart.repository.UserRepository;
import com.smart.service.EmailService;
import com.smart.service.EmailServices;
import com.smart.service.OtpService;
import com.smart.service.UserService;

	@RestController
	@RequestMapping("/api/auth")
	@CrossOrigin("*")
	public class AuthController {
		
		@Autowired
		private UserRepository userRepo;

	    @Autowired
	    private AuthenticationManager authenticationManager;

	    @Autowired
	    private UserService userService;

	    @Autowired
	    private OtpService otpService;

	    @Autowired
	    private EmailService emailService;
	    

		@Autowired
		private EmailServices email;

	    @Autowired
	    private JwtUtil jwtUtil;

	    // User login with username and password
	    @PostMapping("/login")
	    public String login(@RequestBody Userss user) {
	    	System.out.println("This si  1");
	        Authentication authentication = authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
	        System.out.println("This si  2");
	        SecurityContextHolder.getContext().setAuthentication(authentication);

	        // Generate and send OTP to user's email
	        Otp otp = otpService.generateOtp(user.getUsername());
//	        emailService.sendOtpEmail(user.getEmail(), otp.getOtpCode());
	        email.sendEmail(user.getEmail(), "Your otp for login to Elearning website is : "
	        		+otp.getOtpCode() +".Please do not share it with any one.You know how much psycho he is ","OTP Verification");
	        return "OTP generated successfully: "+otp.getOtpCode();
	    }

	    // Validate OTP and generate JWT
	    @PostMapping("/verify-otp")
	    public ResponseEntity<?> verifyOtp(@RequestBody OtpRequest otpReq) {
	        Authentication authentication = authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(otpReq.getUsername(), otpReq.getOtp()));
	        SecurityContextHolder.getContext().setAuthentication(authentication);
	        Userss user = userService.findByUsername(otpReq.getUsername()).orElseThrow(()->  new RuntimeException("User not found"));
	        user.setOtpVerified(true);
	        userRepo.save(user);
	        System.out.println(user+"This is the user");
	        // Generate JWT token
	        String jwtToken = jwtUtil.generateToken(otpReq.getUsername());
//	        return "JWT Token: " + jwtToken;
	        return ResponseEntity.ok(new LoginResponse(jwtToken));
	    }
	    
	    
	}
