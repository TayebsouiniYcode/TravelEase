package com.youcode.travelease.service.implementation;

import com.youcode.travelease.entity.Hotel;
import com.youcode.travelease.entity.Room;
import com.youcode.travelease.repository.RoomRepository;
import com.youcode.travelease.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    RoomRepository roomRepository;

    @Override
    public Room getRoomById ( Long id ) {
        Optional<Room> roomOptional = roomRepository.findById ( id );
        if (roomOptional.isPresent ()){
            return roomOptional.get ();
        } else {
            return null;
        }
    }

    @Override
    public Room addRoom ( Room room) {
        return roomRepository.save ( room );
    }
}
