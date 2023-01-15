package com.youcode.travelease.service;

import com.youcode.travelease.dto.HotelDto;
import com.youcode.travelease.entity.Hotel;
import com.youcode.travelease.entity.Reservation;
import com.youcode.travelease.util.ReservationForm;
import org.springframework.stereotype.Service;

import java.util.List;

public interface HotelService {
    HotelDto saveHotel(Hotel hotel);
    Hotel updateHotel(Hotel hotel);
    Hotel deleteHotel(Hotel hotel);
    Hotel deleteHotelById(Long id);
    Hotel selectHotel(Hotel hotel);
    Hotel selectHotelById(Long id);
    List <Hotel> selectAllHotel();

    Hotel approve ( Long id );

    List< Hotel> getApprovedHotel ( Boolean isApproved);

    Reservation reservation ( ReservationForm reservationForm );


    HotelDto mapperDto(Hotel hotel);
}