package com.youcode.travelease.service;

import com.youcode.travelease.dto.FindRoomForm;
import com.youcode.travelease.entity.Hotel;
import com.youcode.travelease.entity.Room;

import java.util.List;

public interface RoomService {
    Room getRoomById(Long id);

    Room addRoom( Room room );

    List< Room> getAllRooms ( );

    List< Room> getDisponibleRoom ( FindRoomForm findRoomForm );
}
