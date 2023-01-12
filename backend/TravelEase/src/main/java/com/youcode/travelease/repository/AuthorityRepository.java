package com.youcode.travelease.repository;

import com.youcode.travelease.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface AuthorityRepository extends JpaRepository < Authority, Long > {
}