package com.youcode.travelease.rest;

import com.youcode.travelease.entity.Reservation;
import com.youcode.travelease.entity.User;
import com.youcode.travelease.service.ReservationService;
import com.youcode.travelease.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/reservation")
@CrossOrigin()
public class ReservationController {
    @Autowired
    private UserService userService;
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/myreservations")
    public List< Reservation > findMyReservations() {
//        Authentication authentication = SecurityContextHolder.getContext ().getAuthentication ();
//        String username = authentication.getPrincipal ().toString ();
//        System.out.println ( username );

        String currentUserName = "";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken )) {
            currentUserName= authentication.getName();
        }

        User user = userService.findByEmail ( currentUserName );

        if (user != null && !user.equals ( new User (  ) )) {
            return this.reservationService.findReservationByUser ( user );
        }


        return new ArrayList <> (  );
    }
}
