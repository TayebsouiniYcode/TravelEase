package com.youcode.travelease.repository;

import com.youcode.travelease.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository < Address, Long > {
}