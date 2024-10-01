package com.smart.service;

import com.smart.entity.Otp;

public interface OtpService {

	boolean validateOtp(String username, String otpCode);

	Otp generateOtp(String username);

}
