package com.youcode.travelease.rest;

import com.youcode.travelease.service.HotelService;
import com.youcode.travelease.service.ReservationService;
import com.youcode.travelease.service.RoomService;
import com.youcode.travelease.util.DashboardStatistique;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin("http://localhost:4051")
@RequiredArgsConstructor
public class DashboardController {

    private final HotelService hotelService;
    private final RoomService roomService;
    private final ReservationService reservationService;

    @GetMapping("/statistique")
    public DashboardStatistique getStatistique() {
        DashboardStatistique dashboardStatistique = new DashboardStatistique (  );

        dashboardStatistique.setNumberOfHotels ( this.hotelService.getNumberOfHotels() );
        dashboardStatistique.setNumberOfRooms ( this.roomService.getNumberOfRooms() );
        dashboardStatistique.setNumberOfReservations ( this.reservationService.getNumberOfReservations() );

        return dashboardStatistique;
    }
}
