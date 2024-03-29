package com.youcode.travelease.service.implementation;

import com.youcode.travelease.dto.FindRoomForm;
import com.youcode.travelease.entity.Hotel;
import com.youcode.travelease.entity.Reservation;
import com.youcode.travelease.entity.Room;
import com.youcode.travelease.repository.HotelRepository;
import com.youcode.travelease.repository.RoomRepository;
import com.youcode.travelease.service.ReservationService;
import com.youcode.travelease.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Service;

import javax.servlet.FilterChain;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    HotelRepository hotelRepository;
    @Autowired
    ReservationService reservationService;

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
    public Optional < Room > findById ( Long id ) {
        return roomRepository.findById ( id );
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

        List<Room> roomList = this.roomRepository.findAllByTypeAndHotel_AddresseHotel_CityAndCapacityIsGreaterThanEqual(findRoomForm.getType (),
                findRoomForm.getCity (), findRoomForm.getCapacity ());

        return roomList;
//        List<Room> allRooms = this.roomRepository.findAll ();
//        List<Room> roomList = new ArrayList <> (  );
//
//        allRooms.forEach ( room -> {
//            if (room != null && !room.equals ( new Room () )) {
//                if (findRoomForm.getCity () != null
//                        && !findRoomForm.getCity ().isEmpty ()
//                        && room.getHotel ().getAddresseHotel ().getCity () != null
//                        && !room.getHotel ().getAddresseHotel ().getCity ().isEmpty ()
//                        && room.getHotel ().getAddresseHotel ().getCity ().equals ( findRoomForm.getCity () )) {
//
//                }
//            }
//        } );

//        return allRooms;
    }

    @Override
    public Room updateRoom ( Room room ) {
        return this.roomRepository.save ( room );
    }

    @Override
    public Hotel getHotelByRoom ( Room room ) {
        return this.hotelRepository.findHotelsByRooms ( room );
    }

    @Override
    public Integer getNumberOfRooms ( ) {
        return Integer.parseInt ( String.valueOf ( this.roomRepository.count ()));
    }

    @Override
    public List < Reservation > getReservationByRoom ( Room room ) {
        return this.reservationService.getReservationsByRoom(room);
    }

    @Override
    public List < Reservation > getReservationByRoomId ( Long idRoom ) {
        Optional<Room> roomOptional = this.roomRepository.findById ( idRoom );
        if (roomOptional.isPresent ()) {
            return this.reservationService.getReservationsByRoom ( roomOptional.get () );
        }
        return null;
    }
}
