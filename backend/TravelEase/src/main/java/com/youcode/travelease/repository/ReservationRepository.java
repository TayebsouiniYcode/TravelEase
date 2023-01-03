package com.youcode.travelease.repository;

import com.youcode.travelease.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository < Reservation, Long > {
}