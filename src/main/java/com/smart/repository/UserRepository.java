package com.smart.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart.entity.Userss;

public interface UserRepository extends JpaRepository<Userss, Long> {
    Optional<Userss> findByUsername(String username);

	boolean existsByUsername(String username);

	Optional<Userss> findByEmail(String email);
}

