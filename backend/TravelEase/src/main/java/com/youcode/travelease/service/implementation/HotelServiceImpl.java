package com.youcode.travelease.service.implementation;

import com.youcode.travelease.dto.HotelDto;
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

    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private ReservationRepository reservationRepository; // TODO use service
    @Autowired
    private UserRepository userRepository; // TODO use service
    @Autowired
    private RoomService roomService; // TODO use service



    @Override
    public HotelDto saveHotel ( Hotel hotel ) {
        ResponseMessage message = new ResponseMessage ();
        HotelDto hotelDto = new HotelDto ();
        User proprietaire = userRepository.findByEmail ( "tayeb@gmail.com" ); // TODO use user from front end
        hotel.setProprietaire ( proprietaire );
        hotel.setApproved ( false );

        try {
            if (proprietaire != null && !proprietaire.equals ( new User (  ) )) {
                if (hotel != null && !hotel.equals ( new Hotel () )) {
                    if ( hotel.getName () != null && !hotel.getName ().isEmpty ()) {
                        if (hotel.getAddresseHotel () != null && !hotel.getAddresseHotel ().equals (  new AddresseHotel () )) {
                            message.setStatus ( 200 );
                            message.setStatusName ( "Success");
                            message.setMessage ( "Hotel has ben inserted in database" );
                            hotelDto = mapperDto ( hotelRepository.save ( hotel ) );
                            hotelDto.setMessage ( message );
                        } else {
                            message.setStatus ( 500 );
                            message.setStatusName ( "Error");
                            message.setMessage ( "Address is require" );
                            hotelDto = mapperDto ( hotel );
                            hotelDto.setMessage ( message );
                        }
                    } else {
                        message.setStatus ( 500 );
                        message.setStatusName ( "Error");
                        message.setMessage ( "Hotel name is empty" );
                        hotelDto = mapperDto ( hotel );
                        hotelDto.setMessage ( message );
                    }
                } else {
                    message.setStatus ( 500 );
                    message.setStatusName ( "Error");
                    message.setMessage ( "Hotel is empty or null" );
                    hotelDto = mapperDto ( hotel );
                    hotelDto.setMessage ( message );
                }
            } else {
                message.setStatus ( 500 );
                message.setStatusName ( "Error");
                message.setMessage ( "User not found in database" );
                hotelDto = mapperDto ( hotel );
                hotelDto.setMessage ( message );
            }
        } catch (Exception e) {
            message.setStatus ( 500 );
            message.setStatusName ( "Exception");
            message.setMessage ( e.getMessage () );
            hotelDto = mapperDto ( hotel );
            hotelDto.setMessage ( message );
            return  hotelDto ;
        }

        return  hotelDto ;
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

    @Override
    public HotelDto mapperDto ( Hotel hotel) {
        return new HotelDto ( hotel.getName (), hotel.getAddresseHotel (), null);
    }


}
