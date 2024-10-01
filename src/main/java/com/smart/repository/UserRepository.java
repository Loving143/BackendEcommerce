package com.smart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart.entity.Userss;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<Userss, Long> {
    Optional<Userss> findByUsername(String username);
}

