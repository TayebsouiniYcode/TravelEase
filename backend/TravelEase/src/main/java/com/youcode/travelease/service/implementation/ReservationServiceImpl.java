package com.youcode.travelease.service.implementation;

import com.youcode.travelease.entity.Reservation;
import com.youcode.travelease.entity.Room;
import com.youcode.travelease.entity.User;
import com.youcode.travelease.repository.ReservationRepository;
import com.youcode.travelease.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    ReservationRepository reservationRepository;

    @Override
    public List < Reservation > findReservationByUser ( User user ) {
        return reservationRepository.findAllByUser ( user );
    }

    @Override
    public Integer getNumberOfReservations ( ) {
        return Integer.parseInt ( String.valueOf ( this.reservationRepository.count () ) );
    }

    @Override
    public List < Reservation > getReservationsByRoom ( Room room ) {
        return this.reservationRepository.findAllByRoom ( room );
    }
}
