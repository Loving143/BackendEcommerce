package com.smart.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart.entity.PasswordResetToken;
import com.smart.entity.Userss;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Integer>{

	Optional<PasswordResetToken> findByToken(String token);

}
