package com.youcode.travelease.util;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
public class DashboardStatistique implements Serializable {
    private Integer numberOfHotels;
    private Integer numberOfReservations;
    private Integer numberOfRooms;

    public DashboardStatistique ( ) {
    }
}
