package com.youcode.travelease.rest;

import com.youcode.travelease.dto.HotelDto;
import com.youcode.travelease.entity.Hotel;
import com.youcode.travelease.entity.Reservation;
import com.youcode.travelease.entity.Room;
import com.youcode.travelease.entity.User;
import com.youcode.travelease.service.HotelService;
import com.youcode.travelease.service.RoomService;
import com.youcode.travelease.util.ReservationForm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotel")
@CrossOrigin(origins = "http://localhost:4051")
public class HotelController {

    private  HotelService hotelService;
    private  RoomService roomService;

    public HotelController ( HotelService hotelService , RoomService roomService ) {
        this.hotelService = hotelService;
        this.roomService = roomService;
    }

    @PostMapping("/add")
    @ResponseBody
    public HotelDto addHotel( @RequestBody Hotel hotel ) {
        return hotelService.saveHotel ( hotel );
    }

    @GetMapping("/hotels")
    public List< Hotel> getAllHotels() {
//        Authentication authentication = SecurityContextHolder.getContext ().getAuthentication ();
//        String username = authentication.getPrincipal ().toString ();
////        System.out.println ( username );
        return hotelService.selectAllHotel ();
    }

    @GetMapping("/{id}")
    public Hotel getHotelById(@PathVariable Long id){
        Hotel hotel =  hotelService.selectHotelById ( id );
        return hotel;
    }

    @PutMapping("/update")
    public Hotel updateHotelByHotel(@RequestBody Hotel hotel){
        return hotelService.updateHotel ( hotel );
    }

    @DeleteMapping("/delete/{id}")
    public Hotel deleteHotelById(@PathVariable Long id){
        return hotelService.deleteHotelById ( id );
    }

    @PutMapping("/approve/{id}")
    public Hotel approveHotel(@PathVariable Long id) {
        return hotelService.approve(id);
    }

    @GetMapping("/approved")
    public List<Hotel> getApprovedHotels(){
        return hotelService.getApprovedHotel(false);
    }

    @PostMapping("/reservation")
    public Reservation sendReservation(@RequestBody ReservationForm reservationForm) {
        return hotelService.reservation(reservationForm);
    }

    @PostMapping("/addroom/{id}")
    public Room addRoom( @RequestBody Room room, @PathVariable Long id ){
        Hotel hotel = hotelService.selectHotelById ( id );

        try {
            if (hotel != null && !hotel.equals ( new Hotel () )) {
                room.setHotel ( hotel );
                return roomService.addRoom(room);
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/toapprove")
    public List< Hotel > getHotelWithApprovedIsFalse(){
        return hotelService.getApprovedHotel (false);
    }
}