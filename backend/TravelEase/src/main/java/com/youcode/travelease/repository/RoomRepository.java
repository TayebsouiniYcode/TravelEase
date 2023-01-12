package com.youcode.travelease.repository;

import com.youcode.travelease.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface RoomRepository extends JpaRepository < Room, Long > {
    List <Room> findAllByTypeAndCapacityGreaterThanEqual(String type, Integer capacity);

    List<Room> findAllByTypeAndHotel_AddresseHotel_CityAndCapacityIsGreaterThanEqual(String type, String city, Integer capacity);
}