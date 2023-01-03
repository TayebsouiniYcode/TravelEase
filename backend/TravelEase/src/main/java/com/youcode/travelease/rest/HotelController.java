package com.youcode.travelease.rest;

import com.youcode.travelease.entity.Hotel;
import com.youcode.travelease.entity.Reservation;
import com.youcode.travelease.service.HotelService;
import com.youcode.travelease.util.ReservationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotel")
public class HotelController {

    @Autowired
    HotelService hotelService;

    @PostMapping("/add")
    @ResponseBody
    public Hotel addHotel( @RequestBody Hotel hotel ) {
        return hotelService.saveHotel ( hotel );
    }

    @GetMapping("/hotels")
    public List< Hotel> getAllHotels() {
        return hotelService.selectAllHotel ();
    }

    @GetMapping("/{id}")
    public Hotel getHotelById(@PathVariable Long id){
        return hotelService.selectHotelById ( id );
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
        return hotelService.getApprovedHotel();
    }

    @PostMapping("/reservation")
    @ResponseBody
    public Reservation sendReservation(@RequestBody ReservationForm reservationForm) {
        return hotelService.reservation(reservationForm);
    }
}