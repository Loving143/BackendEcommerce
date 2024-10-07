package com.smart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	
	    @Autowired
	    private static JavaMailSender mailSender;

	    // Send OTP via email
	    public static void sendOtpEmail(String to, String otpCode) {
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setTo(to);
	        message.setSubject("Your OTP Code");
	        message.setText("Your OTP code is: " + otpCode);
	        mailSender.send(message);
	    }

		public void sendEmail(String to, String subject, String text) {
			SimpleMailMessage message = new SimpleMailMessage();
	        message.setTo(to);
	        message.setSubject(subject);
	        message.setText(text);
	        mailSender.send(message);
			
		}
	

}
