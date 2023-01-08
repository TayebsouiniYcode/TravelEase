package com.youcode.travelease.service.implementation;

import com.youcode.travelease.entity.*;
import com.youcode.travelease.repository.HotelRepository;
import com.youcode.travelease.repository.ReservationRepository;
import com.youcode.travelease.repository.UserRepository;
import com.youcode.travelease.service.HotelService;
import com.youcode.travelease.service.RoomService;
import com.youcode.travelease.util.ReservationForm;
import com.youcode.travelease.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceImpl implements HotelService {
    //
    //    TODO
    //    Optimisation du code
    //    Appel des service au lieu des repository

    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoomService roomService;

    @Override
    public Hotel saveHotel ( Hotel hotel ) {
        hotel.setApproved ( false );
        hotelRepository.save ( hotel );
        return hotel;
    }

    @Override
    public Hotel updateHotel ( Hotel hotel ) {
        return hotelRepository.save ( hotel );
    }

    @Override
    public Hotel deleteHotel ( Hotel hotel ) {
        hotelRepository.delete ( hotel );
        return hotel;
    }

    @Override
    public Hotel deleteHotelById ( Long id ) {
        ResponseMessage responseMessage = new ResponseMessage ();
        Optional<Hotel> hotelOptional = hotelRepository.findById ( id  );
        if (hotelOptional.isPresent ()) {
            try {
                hotelRepository.delete ( hotelOptional.get () );
                responseMessage.setMessage ( "Hotel has ben deleted" );
                hotelOptional.get ().setMessage ( responseMessage );
            } catch (Exception e) {
                responseMessage.setStatusName ( e.getMessage () );
                responseMessage.setMessage ( "Hotel dont delete !" );
                hotelOptional.get ().setMessage ( responseMessage );
            } finally {
                return hotelOptional.get ();
            }
        } else {
            Hotel hotel = new Hotel ();
            responseMessage.setMessage ( "Hotel not found in database" );
            hotel.setMessage ( responseMessage );
            return hotel;
        }
    }

    @Override
    public Hotel selectHotel ( Hotel hotel ) {
        return null;
    }

    @Override
    public Hotel selectHotelById ( Long id ) {
        Optional<Hotel> hotelOptional = hotelRepository.findById (  id  );
        if (hotelOptional.isPresent ()){
            return hotelOptional.get ();
        } else {
            Hotel hotel = new Hotel ();
            ResponseMessage responseMessage = new ResponseMessage ();
            responseMessage.setMessage ( "id not found in table Hotel ! " );
            hotel.setMessage ( responseMessage );
            return hotel;
        }
    }

    @Override
    public List < Hotel > selectAllHotel ( ) {
        return hotelRepository.findAll ();
    }

    @Override
    public Hotel approve ( Long id ) {
        Optional<Hotel> hotelOptional = hotelRepository.findById ( id );
        hotelOptional.get ().setApproved ( true );
        hotelRepository.save ( hotelOptional.get () );
        return hotelOptional.get ();
    }

    @Override
    public List < Hotel > getApprovedHotel ( Boolean isApproved ) {
        return hotelRepository.findByApproved ( isApproved );
    }

    @Override
    public Reservation reservation ( ReservationForm reservationForm ) {
        /*
        * TODO check user and room
        * */
        Reservation reservation = new Reservation ();
        reservation.setDateDebut ( reservationForm.getDateDebut () );
        reservation.setDateFin ( reservationForm.getDateFin () );

        Room room = roomService.getRoomById ( reservationForm.getIdRoom ());

        Optional<User> userOptional = userRepository.findById ( reservationForm.getIdUser () );
        User user = userOptional.get ();

        if (room != null && !room.equals ( new Room () ) && user != null && !user.equals ( new User () )) {
            reservation.setRoom ( room );
            reservation.setUser ( user );
        }

        reservationRepository.save ( reservation );
        return reservation;
    }
}
