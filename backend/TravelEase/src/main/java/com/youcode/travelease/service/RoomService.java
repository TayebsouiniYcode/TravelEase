package com.youcode.travelease.service;

import com.youcode.travelease.entity.Hotel;
import com.youcode.travelease.entity.Room;

public interface RoomService {
    Room getRoomById(Long id);

    Room addRoom( Room room );
}
