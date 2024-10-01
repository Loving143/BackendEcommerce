package com.smart.service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.entity.Otp;
import com.smart.repository.OtpRepository;
@Service
public class OtpServiceImpl implements OtpService {


	    @Autowired
	    private OtpRepository otpRepository;

	    // Generate OTP and save it
	    public Otp generateOtp(String username) {
	        String otpCode = String.format("%06d", new Random().nextInt(999999));
	        Otp otp = new Otp();
	        otp.setUsername(username);
	        otp.setOtpCode(otpCode);
	        otp.setExpiryTime(LocalDateTime.now().plusMinutes(5)); // 5 minutes expiry
	        otpRepository.save(otp);
	        return otp;
	    }

	    // Validate the OTP
	    public boolean validateOtp(String username, String otpCode) {
	        Optional<Otp> otpOpt = otpRepository.findByUsernameAndOtpCode(username, otpCode);
	        if (otpOpt.isPresent() && otpOpt.get().getExpiryTime().isAfter(LocalDateTime.now())) {
	            return true;
	        }
	        return false;
	    }
	

}
