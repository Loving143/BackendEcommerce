package com.smart.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart.entity.Otp;

public interface OtpRepository extends JpaRepository<Otp,Integer>{
	Optional<Otp> findByUsernameAndOtpCode(String username, String otpCode);
}
