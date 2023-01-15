package com.youcode.travelease.dto;

import com.youcode.travelease.entity.AddresseHotel;
import com.youcode.travelease.util.ResponseMessage;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@RequiredArgsConstructor
public class HotelDto implements Serializable {
    private  String name;
    private  AddresseHotel address;
    private  ResponseMessage message;

    public HotelDto ( String name , AddresseHotel addresseHotel , ResponseMessage message ) {
        this.name = name;
        this.address = addresseHotel;
        this.message = message;
    }
}