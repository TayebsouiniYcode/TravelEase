package com.youcode.travelease.dto;

import com.youcode.travelease.entity.AddresseHotel;
import com.youcode.travelease.util.ResponseMessage;
import lombok.Data;

import java.io.Serializable;

@Data
public class HotelDto implements Serializable {
    private final Long id;
    private final String name;
    private final AddresseHotel address;
    private final ResponseMessage message;
}