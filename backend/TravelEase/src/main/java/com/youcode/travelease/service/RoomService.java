package com.youcode.travelease.service;

import com.youcode.travelease.dto.FindRoomForm;
import com.youcode.travelease.entity.Hotel;
import com.youcode.travelease.entity.Reservation;
import com.youcode.travelease.entity.Room;

import java.util.List;
import java.util.Optional;

public interface RoomService {
    Room getRoomById(Long id);

    Optional <Room> findById(Long id);
    Room addRoom( Room room );

    List< Room> getAllRooms ( );

    List< Room> getDisponibleRoom ( FindRoomForm findRoomForm );

    Room updateRoom ( Room room );

    Hotel getHotelByRoom ( Room room );

    Integer getNumberOfRooms ( );

    List< Reservation> getReservationByRoom ( Room room );

    List< Reservation> getReservationByRoomId ( Long idRoom );
}
