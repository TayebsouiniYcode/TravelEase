package com.youcode.travelease.service.implementation;

import com.youcode.travelease.dto.FindRoomForm;
import com.youcode.travelease.entity.Hotel;
import com.youcode.travelease.entity.Room;
import com.youcode.travelease.repository.RoomRepository;
import com.youcode.travelease.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

    @Override
    public List < Room > getAllRooms ( ) {
        return roomRepository.findAll ();
    }

    @Override
    public List < Room > getDisponibleRoom ( FindRoomForm findRoomForm ) {
        //List<Room> roomList =  this.roomRepository.findAllByTypeAndCapacityGreaterThanEqual ( findRoomForm.getType (), findRoomForm.getCapacity () );
        List<Room> allRooms = this.roomRepository.findAll ();
        List<Room> roomList = new ArrayList <> (  );

        allRooms.forEach ( room -> {
            if (room.getHotel ().getAddresseHotel ().getCity ().equals ( findRoomForm.getCity () ) &&
                    room.getCapacity () >= findRoomForm.getCapacity ( ) &&
                    room.getType ().equals ( findRoomForm.getType () )) {
                roomList.add ( room );
            }
        } );

        return roomList;
    }
}
