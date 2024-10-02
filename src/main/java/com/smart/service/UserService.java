package com.smart.service;

import java.util.Optional;

import com.smart.dto.ChangePasswordRequest;
import com.smart.entity.Userss;
import com.smart.request.RegisterRequest;

public interface UserService {

	Optional<Userss> findByUsername(String username);

	void registerUser(RegisterRequest user) throws Exception;

	Userss getUserDetails(String username);

	void changePassword(ChangePasswordRequest request);

}
