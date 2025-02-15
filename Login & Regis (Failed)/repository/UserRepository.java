package com.example.technical_assessment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.technical_assessment.model.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}