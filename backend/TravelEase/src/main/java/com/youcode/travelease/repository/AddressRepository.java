package com.youcode.travelease.repository;

import com.youcode.travelease.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface AddressRepository extends JpaRepository < Address, Long > {
}