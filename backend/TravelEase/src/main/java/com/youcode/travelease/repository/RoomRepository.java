package com.youcode.travelease.repository;

import com.youcode.travelease.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository < Room, Long > {
}