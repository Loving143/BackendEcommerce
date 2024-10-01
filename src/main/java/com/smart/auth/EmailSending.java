package com.smart.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.smart.service.EmailServices;

@Service
public class EmailSending implements EmailServices  {
	
	@Autowired
	JavaMailSender javaMailSender;
	
	@Value("${spring.mail.username")
	private String fromEmailId;
	
	public void sendEmail(String recipient , String body , String subject) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom(fromEmailId);
		mailMessage.setTo(recipient);
		mailMessage.setText(body);
		mailMessage.setSubject(subject);
		
		javaMailSender.send(mailMessage);
	}

	

}