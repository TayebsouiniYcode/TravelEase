package com.youcode.travelease.rest;

import com.youcode.travelease.service.HotelService;
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

    @GetMapping("/statistique")
    public DashboardStatistique getStatistique() {
        DashboardStatistique dashboardStatistique = new DashboardStatistique (  );

        dashboardStatistique.setNumberOfHotels ( hotelService.getNumberOfHotels() );


        return dashboardStatistique;
    }
}
