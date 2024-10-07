package com.smart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@EnableAdminServer
@SpringBootApplication
public class JsonUpload1Application {

	public static void main(String[] args) { 
		SpringApplication.run(JsonUpload1Application.class, args); 
	} 

}
