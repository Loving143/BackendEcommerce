package com.smart.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;

import com.smart.dto.ChangePasswordRequest;
import com.smart.entity.Userss;

public interface UserService {

	Optional<Userss> findByUsername(String username);

	void registerUser(Userss user);

	Userss getUserDetails(String username);

	void changePassword(ChangePasswordRequest request);

}
