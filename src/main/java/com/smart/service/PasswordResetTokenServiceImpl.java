package com.smart.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.smart.entity.PasswordResetToken;
import com.smart.entity.Userss;
import com.smart.repository.PasswordResetTokenRepository;
import com.smart.repository.UserRepository;

@Service
public class PasswordResetTokenServiceImpl {

	@Autowired
    private PasswordResetTokenRepository tokenRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailServices emailService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void sendPasswordResetToken(String email) {
        Userss user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        String token = UUID.randomUUID().toString();
        PasswordResetToken resetToken = new PasswordResetToken(token, user);
        tokenRepository.save(resetToken);

        String resetUrl = "http://localhost:8080/api/auth/reset-password?token=" + token;
        emailService.sendEmail(user.getEmail(),
                "Click the link to reset your password: " + resetUrl, "Password Reset Request");
    }

    public void updatePassword(String token, String newPassword) {
        PasswordResetToken resetToken = tokenRepository.findByToken(token)
                .orElseThrow(() -> new RuntimeException("Invalid token"));

        if (resetToken.isExpired()) {
            throw new RuntimeException("Token has expired");
        }

        Userss user = resetToken.getUser();
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);

        tokenRepository.delete(resetToken);  // Token is consumed and deleted after use
    }
}
