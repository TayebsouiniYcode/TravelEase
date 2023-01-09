package com.youcode.travelease.repository;

import com.youcode.travelease.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository < Room, Long > {
    List <Room> findAllByTypeAndCapacityGreaterThanEqual(String type, Integer capacity);
}