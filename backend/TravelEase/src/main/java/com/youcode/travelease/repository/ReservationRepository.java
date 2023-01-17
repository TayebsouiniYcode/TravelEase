package com.youcode.travelease.repository;

import com.youcode.travelease.entity.Reservation;
import com.youcode.travelease.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ReservationRepository extends JpaRepository < Reservation, Long > {
    List<Reservation> findAllByUser( User user );
}