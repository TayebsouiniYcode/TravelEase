package com.youcode.travelease.service;

import com.youcode.travelease.entity.Reservation;
import com.youcode.travelease.entity.Room;
import com.youcode.travelease.entity.User;

import java.util.List;

public interface ReservationService {

    List< Reservation > findReservationByUser( User user );

    Integer getNumberOfReservations ( );

    List< Reservation> getReservationsByRoom ( Room room );
}
