package com.youcode.travelease.repository;

import com.youcode.travelease.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository< User, Long > {
}