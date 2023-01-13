package com.youcode.travelease.repository;

import com.youcode.travelease.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UserRepository extends JpaRepository< User, Long > {
//    User findByUsername(String username);
    Optional<User> findByUsername(String username);
    User findByEmail(String email);
}