package com.youcode.travelease.repository;

import com.youcode.travelease.entity.Hotel;
import com.youcode.travelease.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepository extends JpaRepository < Hotel, Long > {
    List <Hotel> findByApproved(Boolean isApproved);

    Hotel findHotelsByRooms( Room room );
}